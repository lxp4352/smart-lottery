package cn.easyjava.lottery.domain.strategy.service.draw;

import cn.easyjava.lottery.domain.common.Constants;
import cn.easyjava.lottery.domain.strategy.model.aggregates.StrategyRich;
import cn.easyjava.lottery.domain.strategy.model.req.DrawRequest;
import cn.easyjava.lottery.domain.strategy.model.resp.DrawResult;
import cn.easyjava.lottery.domain.strategy.model.vo.*;
import cn.easyjava.lottery.domain.strategy.service.algorithm.IDrawAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 定义抽奖抽象模板
 * <br/>
 * AbstractDrawBase
 *
 * @author laiql
 * @date 2021/12/1 15:33
 */
public abstract class AbstractDrawBase extends DrawStrategySupport implements IDrawExec {
    private Logger logger = LoggerFactory.getLogger(AbstractDrawBase.class);

    @Override
    public DrawResult doDrawExec(DrawRequest request) {
        // 1.获取抽奖策略配置数据
        StrategyRich strategyRich = super.queryStrategyRich(request.getStrategyId());
        StrategyBriefVO strategyBriefVO = strategyRich.getStrategyVO();

        // 2. 校验抽奖策略是否已经初始化到内存
        this.checkAndInitRateData(request.getStrategyId(), strategyBriefVO.getStrategyMode(), strategyRich.getStrategyDetailVOList());

        // 3. 获取不在抽奖范围内的列表，包括：奖品库存为空、风控策略、临时调整等
        List<String> excludeAwardIds = this.queryExcludeAwardIds(request.getStrategyId());

        // 4. 执行抽奖算法
        String awardId = this.drawAlgorithm(request.getStrategyId(), drawAlgorithmMap.get(strategyBriefVO.getStrategyMode()), excludeAwardIds);
        // 5. 包装中奖结果
        return buildDrawResult(request.getUserId(), request.getStrategyId(), awardId);
    }

    /**
     * 获取不在抽奖范围内的列表，包括：奖品库存为空、风控策略、临时调整等，这类数据是含有业务逻辑的，所以需要由具体的实现方决定
     *
     * @param strategyId 策略ID
     * @return 排除的奖品ID集合
     */
    protected abstract List<String> queryExcludeAwardIds(Long strategyId);

    /**
     * 执行抽奖算法
     *
     * @param strategyId      策略ID
     * @param drawAlgorithm   抽奖算法模型
     * @param excludeAwardIds 排除的抽奖ID集合
     * @return 中奖奖品ID
     */
    protected abstract String drawAlgorithm(Long strategyId, IDrawAlgorithm drawAlgorithm, List<String> excludeAwardIds);

    /**
     * 检查抽奖策略是否已经初始化
     *
     * @param strategyId           策略id
     * @param strategyMode         策略配置模式
     * @param strategyDetailBriefVOList 策略配置明细
     */
    private void checkAndInitRateData(Long strategyId, Integer strategyMode, List<StrategyDetailBriefVO> strategyDetailBriefVOList) {
        // 非单项概率，不必存入缓存
        if (!Constants.StrategyMode.SINGLE.getCode().equals(strategyMode)) {
            return;
        }

        IDrawAlgorithm drawAlgorithm = drawAlgorithmMap.get(strategyMode);

        // 已初始化过的数据，不必重复初始化
        if (drawAlgorithm.isExistRateTuple(strategyId)) {
            return;
        }

        // 解析并初始化中奖概率数据到散列表
        List<AwardRateInfoVO> awardRateInfoList = new ArrayList<>(strategyDetailBriefVOList.size());
        for (StrategyDetailBriefVO strategyDetail : strategyDetailBriefVOList) {
            awardRateInfoList.add(new AwardRateInfoVO(strategyDetail.getAwardId(), strategyDetail.getAwardRate()));
        }
        //初始化概率数据到散列表
        drawAlgorithm.initRateTuple(strategyId, awardRateInfoList);
    }

    /**
     * 包装抽奖结果
     *
     * @param userId     用户ID
     * @param strategyId 策略ID
     * @param awardId    奖品ID，null 情况：并发抽奖情况下，库存临界值1 -> 0，会有用户中奖结果为 null
     * @return 中奖结果
     */
    private DrawResult buildDrawResult(String userId, Long strategyId, String awardId) {
        if (null == awardId) {
            logger.info("执行策略抽奖完成【未中奖】，用户：{} 策略ID：{}", userId, strategyId);
            return new DrawResult(userId, strategyId, Constants.DrawState.FAIL.getCode());
        }

        AwardBriefVO awardBriefVO = super.queryAwardInfoByAwardId(awardId);
        DrawAwardInfoVO drawAwardInfo = new DrawAwardInfoVO(awardBriefVO.getAwardId(), awardBriefVO.getAwardName(), awardBriefVO.getAwardType(), awardBriefVO.getAwardContent());
        logger.info("执行策略抽奖完成【已中奖】，用户：{} 策略ID：{} 奖品ID：{} 奖品名称：{}", userId, strategyId, awardId, awardBriefVO.getAwardName());

        return new DrawResult(userId, strategyId, Constants.DrawState.SUCCESS.getCode(), drawAwardInfo);
    }
}

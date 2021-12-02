package cn.easyjava.lottery.domain.strategy.service.draw;

import cn.easyjava.lottery.domain.strategy.model.vo.AwardRateInfoVO;
import cn.easyjava.lottery.domain.strategy.model.vo.StrategyDetailVO;
import cn.easyjava.lottery.domain.strategy.service.algorithm.IDrawAlgorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 基础抽奖模式
 * <br/>
 * DrawBase
 *
 * @author laiql
 * @date 2021/12/1 10:43
 */
public class DrawBase extends DrawConfig {

    /**
     * 校验抽奖策略配置初始化
     *
     * @param strategyId           策略id
     * @param strategyMode         抽奖策略模式
     * @param strategyDetailVOList 策略明细
     */
    public void checkAndInitRateData(Long strategyId, Integer strategyMode, List<StrategyDetailVO> strategyDetailVOList) {
        if (2 != strategyMode) return;
        IDrawAlgorithm drawAlgorithm = drawAlgorithmMap.get(strategyMode);

        boolean existRateTuple = drawAlgorithm.isExistRateTuple(strategyId);
        if (existRateTuple) return;

        List<AwardRateInfoVO> awardRateInfoList = new ArrayList<>(strategyDetailVOList.size());
        for (StrategyDetailVO strategyDetailVO : strategyDetailVOList) {
            awardRateInfoList.add(new AwardRateInfoVO(strategyDetailVO.getAwardId(), strategyDetailVO.getAwardRate()));
        }

        drawAlgorithm.initRateTuple(strategyId, awardRateInfoList);
    }

}
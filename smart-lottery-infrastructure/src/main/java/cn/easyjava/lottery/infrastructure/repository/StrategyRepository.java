package cn.easyjava.lottery.infrastructure.repository;

import cn.easyjava.lottery.domain.strategy.model.aggregates.StrategyRich;
import cn.easyjava.lottery.domain.strategy.model.vo.AwardBriefVO;
import cn.easyjava.lottery.domain.strategy.model.vo.StrategyDetailBriefVO;
import cn.easyjava.lottery.domain.strategy.model.vo.StrategyBriefVO;
import cn.easyjava.lottery.domain.strategy.repository.IStrategyRepository;
import cn.easyjava.lottery.infrastructure.dao.IAwardDao;
import cn.easyjava.lottery.infrastructure.po.Award;
import cn.easyjava.lottery.infrastructure.common.convert.AwardConvertAwardVO;
import cn.easyjava.lottery.infrastructure.common.convert.StrategyConvertStrategyVO;
import cn.easyjava.lottery.infrastructure.common.convert.StrategyDetailConvertStrategyDetailVO;
import cn.easyjava.lottery.infrastructure.dao.IStrategyDao;
import cn.easyjava.lottery.infrastructure.dao.IStrategyDetailDao;
import cn.easyjava.lottery.infrastructure.po.Strategy;
import cn.easyjava.lottery.infrastructure.po.StrategyDetail;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Description: 策略配置仓储实现
 * <br/>
 * StrategyRepository
 *
 * @author laiql
 * @date 2021/11/30 16:45
 */
@Repository
public class StrategyRepository implements IStrategyRepository {
    @Resource
    private IStrategyDao strategyDao;
    @Resource
    private IStrategyDetailDao strategyDetailDao;
    @Resource
    private IAwardDao awardDao;
    @Resource
    private AwardConvertAwardVO awardConvertAwardVO;
    @Resource
    private StrategyConvertStrategyVO strategyConvertStrategyVO;
    @Resource
    private StrategyDetailConvertStrategyDetailVO strategyDetailConvertStrategyDetailVO;

    @Override
    public StrategyRich queryStrategyRich(Long strategyId) {
        LambdaQueryWrapper<Strategy> strategyLambdaQueryWrapper = new LambdaQueryWrapper<>();
        strategyLambdaQueryWrapper.eq(true, Strategy::getStrategyId, strategyId);
        Strategy strategy = strategyDao.selectOne(strategyLambdaQueryWrapper);
        StrategyBriefVO strategyBriefVO = strategyConvertStrategyVO.o1ToO2(strategy);

        LambdaQueryWrapper<StrategyDetail> strategyDetailLambdaQueryWrapper = new LambdaQueryWrapper<>();
        strategyDetailLambdaQueryWrapper.eq(true, StrategyDetail::getStrategyId, strategyId);
        List<StrategyDetail> strategyDetails = strategyDetailDao.selectList(strategyDetailLambdaQueryWrapper);
        List<StrategyDetailBriefVO> strategyDetailBriefVOS = strategyDetailConvertStrategyDetailVO.o1sToO2s(strategyDetails);

        return new StrategyRich(strategyId, strategyBriefVO, strategyDetailBriefVOS);
    }

    @Override
    public AwardBriefVO queryAwardInfo(String awardId) {
        LambdaQueryWrapper<Award> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(true, Award::getAwardId, awardId);
        Award award = awardDao.selectOne(lambdaQueryWrapper);
        return awardConvertAwardVO.o1ToO2(award);
    }

    @Override
    public List<String> queryNoStockStrategyAwardList(Long strategyId) {
        LambdaQueryWrapper<StrategyDetail> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(true, StrategyDetail::getStrategyId, strategyId);
        lambdaQueryWrapper.eq(true, StrategyDetail::getAwardSurplusCount, 0);
        List<StrategyDetail> strategyDetails = strategyDetailDao.selectList(lambdaQueryWrapper);
        return strategyDetails.stream().map(StrategyDetail::getAwardId).collect(Collectors.toList());
    }

    @Override
    public boolean deductStock(Long strategyId, String awardId) {
        StrategyDetail req = new StrategyDetail();
        req.setStrategyId(strategyId);
        req.setAwardId(awardId);
        int deductStock = strategyDetailDao.deductStock(req);
        return deductStock == 1;
    }
}

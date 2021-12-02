package cn.easyjava.lottery.domain.strategy.model.aggregates;

import cn.easyjava.lottery.domain.strategy.model.vo.StrategyDetailBriefVO;
import cn.easyjava.lottery.domain.strategy.model.vo.StrategyBriefVO;

import java.util.List;

/**
 * Description: 抽奖策略聚合对象
 * <p>
 * <br/>
 * StrategyRich
 *
 * @author laiql
 * @date 2021/11/30 16:33
 */
public class StrategyRich {

    /**
     * 策略ID
     */
    private Long strategyId;
    /**
     * 策略配置
     */
    private StrategyBriefVO strategyBriefVO;
    /**
     * 策略明细
     */
    private List<StrategyDetailBriefVO> strategyDetailBriefVOList;

    public StrategyRich() {
    }

    public StrategyRich(Long strategyId, StrategyBriefVO strategyBriefVO, List<StrategyDetailBriefVO> strategyDetailBriefVOList) {
        this.strategyId = strategyId;
        this.strategyBriefVO = strategyBriefVO;
        this.strategyDetailBriefVOList = strategyDetailBriefVOList;
    }

    public Long getStrategyId() {
        return strategyId;
    }

    public void setStrategyId(Long strategyId) {
        this.strategyId = strategyId;
    }

    public StrategyBriefVO getStrategyVO() {
        return strategyBriefVO;
    }

    public void setStrategyVO(StrategyBriefVO strategyBriefVO) {
        this.strategyBriefVO = strategyBriefVO;
    }

    public List<StrategyDetailBriefVO> getStrategyDetailVOList() {
        return strategyDetailBriefVOList;
    }

    public void setStrategyDetailVOList(List<StrategyDetailBriefVO> strategyDetailBriefVOList) {
        this.strategyDetailBriefVOList = strategyDetailBriefVOList;
    }
}

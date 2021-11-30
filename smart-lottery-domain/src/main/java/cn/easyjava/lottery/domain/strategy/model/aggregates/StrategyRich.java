package cn.easyjava.lottery.domain.strategy.model.aggregates;

import cn.easyjava.lottery.domain.strategy.model.vo.StrategyDetailVO;
import cn.easyjava.lottery.domain.strategy.model.vo.StrategyVO;

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

    // 策略ID
    private Long strategyId;
    // 策略配置
    private StrategyVO strategyVO;
    // 策略明细
    private List<StrategyDetailVO> strategyDetailVOList;

    public StrategyRich() {
    }

    public StrategyRich(Long strategyId, StrategyVO strategyVO, List<StrategyDetailVO> strategyDetailVOList) {
        this.strategyId = strategyId;
        this.strategyVO = strategyVO;
        this.strategyDetailVOList = strategyDetailVOList;
    }

    public Long getStrategyId() {
        return strategyId;
    }

    public void setStrategyId(Long strategyId) {
        this.strategyId = strategyId;
    }

    public StrategyVO getStrategyVO() {
        return strategyVO;
    }

    public void setStrategyVO(StrategyVO strategyVO) {
        this.strategyVO = strategyVO;
    }

    public List<StrategyDetailVO> getStrategyDetailVOList() {
        return strategyDetailVOList;
    }

    public void setStrategyDetailVOList(List<StrategyDetailVO> strategyDetailVOList) {
        this.strategyDetailVOList = strategyDetailVOList;
    }
}

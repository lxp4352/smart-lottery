package cn.easyjava.lottery.domain.activity.model.resp;

import cn.easyjava.lottery.domain.common.Result;

/**
 * Description: 活动参与结果
 * <br/>
 * PartakeResult
 *
 * @author laiql
 * @date 2021/12/6 14:05
 */
public class PartakeResult extends Result {
    /**
     * 策略ID
     */
    private Long strategyId;

    /**
     * 活动领取ID
     */
    private Long takeId;


    public PartakeResult(String code, String info) {
        super(code, info);
    }

    public Long getStrategyId() {
        return strategyId;
    }

    public void setStrategyId(Long strategyId) {
        this.strategyId = strategyId;
    }

    public Long getTakeId() {
        return takeId;
    }

    public void setTakeId(Long takeId) {
        this.takeId = takeId;
    }
}

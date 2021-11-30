package cn.easyjava.lottery.domain.strategy.model.req;

/**
 * Description: 抽奖请求
 * <br/>
 * DrawRequest
 *
 * @author laiql
 * @date 2021/11/30 16:31
 */
public class DrawRequest {

    //用户ID
    private String uId;
    // 策略ID
    private Long strategyId;

    public DrawRequest() {
    }

    public DrawRequest(String uId, Long strategyId) {
        this.uId = uId;
        this.strategyId = strategyId;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public Long getStrategyId() {
        return strategyId;
    }

    public void setStrategyId(Long strategyId) {
        this.strategyId = strategyId;
    }
}

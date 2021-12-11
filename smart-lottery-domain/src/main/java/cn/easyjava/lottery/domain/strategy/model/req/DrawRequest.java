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

    /**
     * 用户ID
     */
    private String userId;
    /**
     * 策略ID
     */
    private Long strategyId;

    /**
     * 防重ID
     */
    private String uuid;


    public DrawRequest() {
    }

    public DrawRequest(String userId, Long strategyId, String uuid) {
        this.userId = userId;
        this.strategyId = strategyId;
        this.uuid = uuid;
    }

    public DrawRequest(String userId, Long strategyId) {
        this.userId = userId;
        this.strategyId = strategyId;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getUuid() {
        return uuid;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Long getStrategyId() {
        return strategyId;
    }

    public void setStrategyId(Long strategyId) {
        this.strategyId = strategyId;
    }
}

package cn.easyjava.lottery.domain.strategy.model.resp;

/**
 * Description: 抽奖结果
 * <br/>
 * DrawResult
 *
 * @author laiql
 * @date 2021/11/30 16:31
 */
public class DrawResult {
    // 用户ID
    private String uId;

    // 策略ID
    private Long strategyId;

    // 奖品ID
    private String rewardId;

    // 奖品名称
    private String awardName;

    public DrawResult() {
    }

    public DrawResult(String uId, Long strategyId, String rewardId, String awardName) {
        this.uId = uId;
        this.strategyId = strategyId;
        this.rewardId = rewardId;
        this.awardName = awardName;
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

    public String getRewardId() {
        return rewardId;
    }

    public void setRewardId(String rewardId) {
        this.rewardId = rewardId;
    }

    public String getAwardName() {
        return awardName;
    }

    public void setAwardName(String awardName) {
        this.awardName = awardName;
    }
}

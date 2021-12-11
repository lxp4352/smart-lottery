package cn.easyjava.lottery.domain.activity.model.vo;

/**
 * Description: 用户领取活动记录
 * <br/>
 * UserTakeActivityVO
 *
 * @author laiql
 * @date 2021/12/11 3:57 下午
 */
public class UserTakeActivityVO {

    /**
     * 活动ID
     */
    private Long activityId;

    /**
     * 活动领取ID
     */
    private Long takeId;

    /**
     * 策略ID
     */
    private Long strategyId;

    /**
     * 活动单使用状态 0未使用、1已使用
     * Constants.TaskState
     */
    private Integer state;

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    public Long getTakeId() {
        return takeId;
    }

    public void setTakeId(Long takeId) {
        this.takeId = takeId;
    }

    public Long getStrategyId() {
        return strategyId;
    }

    public void setStrategyId(Long strategyId) {
        this.strategyId = strategyId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "UserTakeActivityVO{" +
                "activityId=" + activityId +
                ", takeId=" + takeId +
                ", strategyId=" + strategyId +
                ", state=" + state +
                '}';
    }

}

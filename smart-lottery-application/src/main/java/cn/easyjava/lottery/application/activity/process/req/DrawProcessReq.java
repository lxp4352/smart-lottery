package cn.easyjava.lottery.application.activity.process.req;

/**
 * Description: 抽奖请求
 * <br/>
 * DrawProcessReq
 *
 * @author laiql
 * @date 2021/12/11 3:45 下午
 */
public class DrawProcessReq {
    /**
     * 用户ID
     */
    private String userId;
    /**
     * 活动ID
     */
    private Long activityId;

    public DrawProcessReq() {
    }

    public DrawProcessReq(String userId, Long activityId) {
        this.userId = userId;
        this.activityId = activityId;
    }

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}

package cn.easyjava.lottery.rpc.req;

import java.io.Serializable;

/**
 * Description: 抽奖请求
 * <br/>
 * DrawReq
 *
 * @author laiql
 * @date 2021/12/12 9:09 下午
 */
public class DrawReq implements Serializable {

    /**
     * 用户ID
     */
    private String userId;
    /**
     * 活动ID
     */
    private Long activityId;

    public DrawReq() {
    }

    public DrawReq(String userId, Long activityId) {
        this.userId = userId;
        this.activityId = activityId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }
}

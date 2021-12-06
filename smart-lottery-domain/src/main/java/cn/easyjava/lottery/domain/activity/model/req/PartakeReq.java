package cn.easyjava.lottery.domain.activity.model.req;

import java.util.Date;

/**
 * Description: 参与活动请求
 * <br/>
 * PartakeReq
 *
 * @author laiql
 * @date 2021/12/6 14:11
 */
public class PartakeReq {

    /**
     * 用户ID
     */
    private String userId;
    /**
     * 活动ID
     */
    private Long activityId;
    /**
     * 活动领取时间
     */
    private Date partakeDate;

    public PartakeReq() {
    }

    public PartakeReq(String userId, Long activityId) {
        this.userId = userId;
        this.activityId = activityId;
        this.partakeDate = new Date();
    }

    public PartakeReq(String userId, Long activityId, Date partakeDate) {
        this.userId = userId;
        this.activityId = activityId;
        this.partakeDate = partakeDate;
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

    public Date getPartakeDate() {
        return partakeDate;
    }

    public void setPartakeDate(Date partakeDate) {
        this.partakeDate = partakeDate;
    }
}
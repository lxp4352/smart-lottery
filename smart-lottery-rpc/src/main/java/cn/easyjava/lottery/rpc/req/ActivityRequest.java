package cn.easyjava.lottery.rpc.req;

import cn.easyjava.lottery.rpc.dto.ActivityDto;

import java.io.Serializable;

/**
 * Description: 活动统一请求对象
 * <br/>
 * ActivityRequest
 *
 * @author laiql
 * @date 2021/11/30 11:11
 */
public class ActivityRequest implements Serializable {
    private Long activityId;
    private ActivityDto activityDto;

    public ActivityRequest() {
    }

    public ActivityRequest(Long activityId) {
        this.activityId = activityId;
    }

    public ActivityRequest(ActivityDto activityDto) {
        this.activityDto = activityDto;
    }

    public ActivityRequest(Long activityId, ActivityDto activityDto) {
        this.activityId = activityId;
        this.activityDto = activityDto;
    }

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    public ActivityDto getActivityDto() {
        return activityDto;
    }

    public void setActivityDto(ActivityDto activityDto) {
        this.activityDto = activityDto;
    }
}

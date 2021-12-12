package cn.easyjava.lottery.application.activity.process.resp;

import cn.easyjava.lottery.domain.common.Result;

/**
 * Description: 规则量化人群结果
 * <br/>
 * RuleQuantificationCrowdResult
 *
 * @author laiql
 * @date 2021/12/12 9:24 下午
 */
public class RuleQuantificationCrowdResult extends Result {

    /**
     * 活动ID
     */
    private Long activityId;

    public RuleQuantificationCrowdResult(String code, String info) {
        super(code, info);
    }

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

}

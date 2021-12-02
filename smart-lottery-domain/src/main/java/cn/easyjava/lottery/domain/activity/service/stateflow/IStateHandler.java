package cn.easyjava.lottery.domain.activity.service.stateflow;

import cn.easyjava.lottery.domain.common.Constants;
import cn.easyjava.lottery.domain.common.Result;

/**
 * Description: 状态处理器接口
 * <br/>
 * IStateHandler
 *
 * @author laiql
 * @date 2021/12/2 15:27
 */
public interface IStateHandler {

    /**
     * 提审
     *
     * @param activityId    活动ID
     * @param currentStatus 当前状态
     * @return 审核结果
     */
    Result arraignment(Long activityId, Enum<Constants.ActivityState> currentStatus);

    /**
     * 审核通过
     *
     * @param activityId    活动ID
     * @param currentStatus 当前状态
     * @return 审核结果
     */
    Result checkPass(Long activityId, Enum<Constants.ActivityState> currentStatus);

    /**
     * 审核拒绝
     *
     * @param activityId    活动ID
     * @param currentStatus 当前状态
     * @return 审核结果
     */
    Result checkRefuse(Long activityId, Enum<Constants.ActivityState> currentStatus);

    /**
     * 撤销审核
     *
     * @param activityId    活动ID
     * @param currentStatus 当前状态
     * @return 审核结果
     */
    Result checkRevoke(Long activityId, Enum<Constants.ActivityState> currentStatus);

    /**
     * 关闭
     *
     * @param activityId    活动ID
     * @param currentStatus 当前状态
     * @return 审核结果
     */
    Result close(Long activityId, Enum<Constants.ActivityState> currentStatus);

    /**
     * 开启
     *
     * @param activityId    活动ID
     * @param currentStatus 当前状态
     * @return 审核结果
     */
    Result open(Long activityId, Enum<Constants.ActivityState> currentStatus);

    /**
     * 运行活动中
     *
     * @param activityId    活动ID
     * @param currentStatus 当前状态
     * @return 审核结果
     */
    Result doing(Long activityId, Enum<Constants.ActivityState> currentStatus);

}

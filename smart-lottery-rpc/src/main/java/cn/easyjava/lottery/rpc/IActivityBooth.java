package cn.easyjava.lottery.rpc;

import cn.easyjava.lottery.common.CommonResult;
import cn.easyjava.lottery.rpc.dto.ActivityDto;
import cn.easyjava.lottery.rpc.req.ActivityRequest;
import cn.easyjava.lottery.rpc.resp.ActivityResponse;

/**
 * Description:
 * 活动展台接口
 * 1. 创建活动
 * 2. 更新活动
 * 3. 查询活动
 * <br/>
 * IActivityBooth
 *
 * @author laiql
 * @date 2021/11/29 16:06
 */
public interface IActivityBooth {

    /**
     * 查询活动
     *
     * @param activityRequest 活动ID
     * @return class CommonResult
     */
    ActivityResponse queryActivityById(ActivityRequest activityRequest);

    /**
     * 创建活动请求
     *
     * @param activityRequest 活动基础信息DTO对象
     * @return class CommonResult
     */
    ActivityResponse createActivity(ActivityRequest activityRequest);
}

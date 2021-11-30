package cn.easyjava.lottery.rpc.resp;

import cn.easyjava.lottery.common.CommonResult;
import cn.easyjava.lottery.rpc.dto.ActivityDto;

import java.io.Serializable;

/**
 * Description: 活动统一响应对象
 * <br/>
 * ActivityResponse
 *
 * @author laiql
 * @date 2021/11/30 11:11
 */
public class ActivityResponse implements Serializable {

    private CommonResult result;
    private ActivityDto activity;

    public ActivityResponse(CommonResult result) {
        this.result = result;
    }

    public ActivityResponse(CommonResult result, ActivityDto activity) {
        this.result = result;
        this.activity = activity;
    }

    public CommonResult getResult() {
        return result;
    }

    public void setResult(CommonResult result) {
        this.result = result;
    }

    public ActivityDto getActivity() {
        return activity;
    }

    public void setActivity(ActivityDto activity) {
        this.activity = activity;
    }
}

package cn.easyjava.lottery.application.activity;

import cn.easyjava.lottery.common.CommonResult;
import cn.easyjava.lottery.infrastructure.dao.IActivityDao;
import cn.easyjava.lottery.infrastructure.po.Activity;
import cn.easyjava.lottery.rpc.IActivityBooth;
import cn.easyjava.lottery.rpc.dto.ActivityDto;
import cn.easyjava.lottery.rpc.req.ActivityRequest;
import cn.easyjava.lottery.rpc.resp.ActivityResponse;
import org.apache.dubbo.config.annotation.Service;

import javax.annotation.Resource;

/**
 * Description: 活动站台业务实现
 * <br/>
 * LotteryActivityBooth
 *
 * @author laiql
 * @date 2021/11/29 16:09
 */
@Service
public class LotteryActivityBooth implements IActivityBooth {
    @Resource
    private IActivityDao activityDao;

    @Override
    public ActivityResponse queryActivityById(ActivityRequest activityRequest) {
        //获取出活动基础信息DO对象
        Activity activity = activityDao.queryActivityById(activityRequest.getActivityId());
        //返回活动基础信息
        return new ActivityResponse(CommonResult.buildSuccessResult(), activityDOConvertActivityDTO(activity));
    }

    @Override
    public ActivityResponse createActivity(ActivityRequest activityRequest) {
        //保存活动基础信息到数据库
        activityDao.insert(activityDTOConvertActivityDO(activityRequest.getActivityDto()));
        return new ActivityResponse(CommonResult.buildSuccessResult());
    }

    private ActivityDto activityDOConvertActivityDTO(Activity activity) {
        ActivityDto activityDto = new ActivityDto();
        activityDto.setActivityId(activity.getActivityId());
        activityDto.setActivityName(activity.getActivityName());
        activityDto.setActivityDesc(activity.getActivityDesc());
        activityDto.setBeginDateTime(activity.getBeginDateTime());
        activityDto.setEndDateTime(activity.getEndDateTime());
        activityDto.setStockCount(activity.getStockCount());
        activityDto.setTakeCount(activity.getTakeCount());
        return activityDto;
    }

    private Activity activityDTOConvertActivityDO(ActivityDto activityDto) {
        Activity activity = new Activity();
        activity.setActivityId(activityDto.getActivityId());
        activity.setActivityName(activityDto.getActivityName());
        activity.setActivityDesc(activityDto.getActivityDesc());
        activity.setBeginDateTime(activityDto.getBeginDateTime());
        activity.setEndDateTime(activityDto.getEndDateTime());
        activity.setStockCount(activityDto.getStockCount());
        activity.setTakeCount(activityDto.getTakeCount());
        return activity;
    }
}

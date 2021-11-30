package cn.easyjava.lottery.application.activity;

import cn.easyjava.lottery.application.activity.convert.ActivityVOConvertActivityDTO;
import cn.easyjava.lottery.common.CommonResult;
import cn.easyjava.lottery.domain.strategy.model.vo.ActivityVO;
import cn.easyjava.lottery.domain.strategy.repository.IActivityRepository;
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
    private IActivityRepository activityRepository;
    @Resource
    private ActivityVOConvertActivityDTO activityVOConvertActivityDTO;

    @Override
    public ActivityResponse queryActivityById(ActivityRequest activityRequest) {
        //获取出活动基础信息VO对象
        ActivityVO activityVO = activityRepository.queryActivityById(activityRequest.getActivityId());
        //将VO对象转成DTO对象
        ActivityDto activityDto = activityVOConvertActivityDTO.o1ToO2(activityVO);
        //返回活动基础信息
        return new ActivityResponse(CommonResult.buildSuccessResult(), activityDto);
    }

    @Override
    public ActivityResponse createActivity(ActivityRequest activityRequest) {
        //保存活动基础信息到数据库
        return new ActivityResponse(CommonResult.buildSuccessResult());
    }
}

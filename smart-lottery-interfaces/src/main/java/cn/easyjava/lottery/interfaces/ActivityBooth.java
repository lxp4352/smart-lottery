package cn.easyjava.lottery.interfaces;

import cn.easyjava.lottery.common.CommonResult;
import cn.easyjava.lottery.dao.IActivityDao;
import cn.easyjava.lottery.dataobject.ActivityDO;
import cn.easyjava.lottery.rpc.IActivityBooth;
import cn.easyjava.lottery.rpc.dto.ActivityDto;
import org.apache.dubbo.config.annotation.Service;

import javax.annotation.Resource;

/**
 * Description: 活动站台业务实现
 * <br/>
 * ActivityBooth
 *
 * @author laiql
 * @date 2021/11/29 16:09
 */
@Service
public class ActivityBooth implements IActivityBooth {

    @Resource
    private IActivityDao activityDao;

    @Override
    public CommonResult<ActivityDto> queryActivityById(Long activityId) {
        //获取出活动基础信息DO对象
        ActivityDO activityDO = activityDao.queryActivityById(activityId);
        //返回活动基础信息
        return CommonResult.buildSuccessResult(activityDOConvertActivityDTO(activityDO));
    }

    @Override
    public CommonResult createActivity(ActivityDto activityDto) {
        //保存活动基础信息到数据库
        activityDao.insert(activityDTOConvertActivityDO(activityDto));
        return CommonResult.buildSuccessResult();
    }

    private ActivityDto activityDOConvertActivityDTO(ActivityDO activityDO) {
        ActivityDto activityDto = new ActivityDto();
        activityDto.setActivityId(activityDO.getActivityId());
        activityDto.setActivityName(activityDO.getActivityName());
        activityDto.setActivityDesc(activityDO.getActivityDesc());
        activityDto.setBeginDateTime(activityDO.getBeginDateTime());
        activityDto.setEndDateTime(activityDO.getEndDateTime());
        activityDto.setStockCount(activityDO.getStockCount());
        activityDto.setTakeCount(activityDO.getTakeCount());
        return activityDto;
    }

    private ActivityDO activityDTOConvertActivityDO(ActivityDto activityDto) {
        ActivityDO activityDO = new ActivityDO();
        activityDO.setActivityId(activityDto.getActivityId());
        activityDO.setActivityName(activityDto.getActivityName());
        activityDO.setActivityDesc(activityDto.getActivityDesc());
        activityDO.setBeginDateTime(activityDto.getBeginDateTime());
        activityDO.setEndDateTime(activityDto.getEndDateTime());
        activityDO.setStockCount(activityDto.getStockCount());
        activityDO.setTakeCount(activityDto.getTakeCount());
        return activityDO;
    }
}

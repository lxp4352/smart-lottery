package cn.easyjava.lottery.infrastructure.repository;

import cn.easyjava.lottery.domain.strategy.model.vo.ActivityVO;
import cn.easyjava.lottery.domain.strategy.repository.IActivityRepository;
import cn.easyjava.lottery.infrastructure.common.convert.ActivityConversionActivityVO;
import cn.easyjava.lottery.infrastructure.dao.IActivityDao;
import cn.easyjava.lottery.infrastructure.po.Activity;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Description: 活动仓储实现
 * <br/>
 * ActivityRepository
 *
 * @author laiql
 * @date 2021/11/30 16:48
 */
@Repository
public class ActivityRepository implements IActivityRepository {
    @Resource
    private IActivityDao activityDao;
    @Resource
    private ActivityConversionActivityVO activityConversionActivityVO;

    @Override
    public ActivityVO queryActivityById(Long activityId) {
        LambdaQueryWrapper<Activity> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(true, Activity::getActivityId, activityId);
        Activity activity = activityDao.selectOne(lambdaQueryWrapper);
        ActivityVO activityVO = activityConversionActivityVO.o1ToO2(activity);
        return activityVO;
    }
}

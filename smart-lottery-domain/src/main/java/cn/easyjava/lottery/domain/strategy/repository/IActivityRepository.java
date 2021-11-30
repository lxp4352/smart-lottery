package cn.easyjava.lottery.domain.strategy.repository;

import cn.easyjava.lottery.domain.strategy.model.vo.ActivityVO;

/**
 * Description: 活动仓储接口
 * <br/>
 * IActivityRepository
 *
 * @author laiql
 * @date 2021/11/30 16:48
 */
public interface IActivityRepository {
    ActivityVO queryActivityById(Long activityId);
}

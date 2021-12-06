package cn.easyjava.lottery.infrastructure.dao;

import cn.easyjava.lottery.domain.activity.model.vo.AlterStateVO;
import cn.easyjava.lottery.infrastructure.po.Activity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * Description: 活动Dao接口
 * <br/>
 * IActivityDao
 *
 * @author laiql
 * @date 2021/12/2 10:45
 */
public interface IActivityDao extends BaseMapper<Activity> {
    /**
     * 变更活动状态
     *
     * @param alterStateVO [activityId、beforeState、afterState]
     * @return 更新数量
     */
    int alterState(AlterStateVO alterStateVO);

    /**
     * 扣减活动库存
     * @param activityId 活动ID
     * @return 更新数量
     */
    int subtractionActivityStock(Long activityId);
}

package cn.easyjava.lottery.dao;

import cn.easyjava.lottery.po.Activity;
import org.apache.ibatis.annotations.Mapper;

/**
 * Description: 活动信息基础Dao接口
 * <br/>
 * IActivityDao
 *
 * @author laiql
 * @date 2021/11/29 15:53
 */
@Mapper
public interface IActivityDao {
    /**
     * 新增活动基础信息
     *
     * @param activity
     * @return
     */
    int insert(Activity activity);

    /**
     * 根据活动id查询活动基础信息
     *
     * @param activityId 活动id
     * @return
     */
    Activity queryActivityById(Long activityId);
}

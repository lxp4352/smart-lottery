package cn.easyjava.lottery.infrastructure.activity.dao;

import cn.easyjava.lottery.infrastructure.activity.po.Activity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * Description: 活动Dao接口
 * <br/>
 * IActivityDao
 *
 * @author laiql
 * @date 2021/12/2 10:45
 */
@Mapper
public interface IActivityDao extends BaseMapper<Activity> {
}

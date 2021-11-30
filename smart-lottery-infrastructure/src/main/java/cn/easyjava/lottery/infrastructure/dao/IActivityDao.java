package cn.easyjava.lottery.infrastructure.dao;

import cn.easyjava.lottery.infrastructure.po.Activity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * Description: 活动基础信息Dao接口
 * <br/>
 * IActivityDao
 *
 * @author laiql
 * @date 2021/11/29 15:53
 */
@Mapper
public interface IActivityDao extends BaseMapper<Activity> {
}

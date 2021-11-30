package cn.easyjava.lottery.infrastructure.dao;

import cn.easyjava.lottery.infrastructure.po.Strategy;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * Description: 策略配置Dao接口
 * <br/>
 * IStrategyDao
 *
 * @author laiql
 * @date 2021/11/30 16:05
 */
@Mapper
public interface IStrategyDao extends BaseMapper<Strategy> {
}

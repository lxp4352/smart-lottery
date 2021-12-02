package cn.easyjava.lottery.infrastructure.award.dao;

import cn.easyjava.lottery.infrastructure.award.po.Award;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * Description: 奖品Dao接口
 * <br/>
 * IAwardDao
 *
 * @author laiql
 * @date 2021/11/30 16:04
 */
@Mapper
public interface IAwardDao extends BaseMapper<Award> {
}

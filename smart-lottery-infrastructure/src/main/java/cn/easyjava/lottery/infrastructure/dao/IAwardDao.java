package cn.easyjava.lottery.infrastructure.dao;

import cn.easyjava.lottery.infrastructure.po.Award;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * Description: 奖品Dao接口
 * <br/>
 * IAwardDao
 *
 * @author laiql
 * @date 2021/11/30 16:04
 */
public interface IAwardDao extends BaseMapper<Award> {
    /**
     * 批量插入奖品
     *
     * @param req 奖品数据
     */
    void insertList(List<Award> req);
}

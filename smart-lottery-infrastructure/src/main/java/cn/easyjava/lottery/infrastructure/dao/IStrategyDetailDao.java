package cn.easyjava.lottery.infrastructure.dao;

import cn.easyjava.lottery.infrastructure.po.StrategyDetail;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * Description: 策略配置明细Dao接口
 * <br/>
 * IStrategyDetailDao
 *
 * @author laiql
 * @date 2021/11/30 16:06
 */
public interface IStrategyDetailDao extends BaseMapper<StrategyDetail> {
    /**
     * 扣减库存
     *
     * @param strategyDetailReq 策略ID、奖品ID
     * @return 返回结果
     */
    int deductStock(StrategyDetail strategyDetailReq);

    /**
     * 插入策略配置组
     *
     * @param list 策略配置组
     */
    void insertList(List<StrategyDetail> list);
}

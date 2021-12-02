package cn.easyjava.lottery.domain.strategy.repository;

import cn.easyjava.lottery.domain.strategy.model.aggregates.StrategyRich;
import cn.easyjava.lottery.domain.strategy.model.vo.AwardVO;

import java.util.List;

/**
 * Description: 策略配置仓储接口
 * <br/>
 * IStrategyRepository
 *
 * @author laiql
 * @date 2021/11/30 16:44
 */
public interface IStrategyRepository {

    StrategyRich queryStrategyRich(Long strategyId);

    AwardVO queryAwardInfo(String awardId);

    List<String> queryNoStockStrategyAwardList(Long strategyId);

    boolean deductStock(Long strategyId, String awardId);
}

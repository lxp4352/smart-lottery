package cn.easyjava.lottery.domain.activity.model.aggregates;

import cn.easyjava.lottery.domain.activity.model.vo.ActivityVO;
import cn.easyjava.lottery.domain.activity.model.vo.AwardVO;
import cn.easyjava.lottery.domain.activity.model.vo.StrategyVO;

/**
 * Description: 活动配置聚合信息
 * <br/>
 * ActivityConfigRich
 *
 * @author laiql
 * @date 2021/12/2 15:07
 */
import java.util.List;

public class ActivityConfigRich {

    /** 活动配置 */
    private ActivityVO activity;

    /** 策略配置(含策略明细) */
    private StrategyVO strategy;

    /** 奖品配置 */
    private List<AwardVO> awardList;

    public ActivityConfigRich() {
    }

    public ActivityConfigRich(ActivityVO activity, StrategyVO strategy, List<AwardVO> awardList) {
        this.activity = activity;
        this.strategy = strategy;
        this.awardList = awardList;
    }

    public ActivityVO getActivity() {
        return activity;
    }

    public void setActivity(ActivityVO activity) {
        this.activity = activity;
    }

    public StrategyVO getStrategy() {
        return strategy;
    }

    public void setStrategy(StrategyVO strategy) {
        this.strategy = strategy;
    }

    public List<AwardVO> getAwardList() {
        return awardList;
    }

    public void setAwardList(List<AwardVO> awardList) {
        this.awardList = awardList;
    }
}

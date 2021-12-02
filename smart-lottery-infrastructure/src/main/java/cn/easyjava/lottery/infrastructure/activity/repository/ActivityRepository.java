package cn.easyjava.lottery.infrastructure.activity.repository;

import cn.easyjava.lottery.domain.activity.model.vo.*;
import cn.easyjava.lottery.domain.activity.repository.IActivityRepository;
import cn.easyjava.lottery.domain.common.Constants;
import cn.easyjava.lottery.infrastructure.activity.dao.IActivityDao;
import cn.easyjava.lottery.infrastructure.activity.po.Activity;
import cn.easyjava.lottery.infrastructure.award.dao.IAwardDao;
import cn.easyjava.lottery.infrastructure.award.po.Award;
import cn.easyjava.lottery.infrastructure.strategy.dao.IStrategyDao;
import cn.easyjava.lottery.infrastructure.strategy.dao.IStrategyDetailDao;
import cn.easyjava.lottery.infrastructure.strategy.po.Strategy;
import cn.easyjava.lottery.infrastructure.strategy.po.StrategyDetail;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Description: 活动仓储类
 * <br/>
 * ActivityRepository
 *
 * @author laiql
 * @date 2021/12/2 15:39
 */
@Repository
public class ActivityRepository implements IActivityRepository {

    @Resource
    private IActivityDao activityDao;
    @Resource
    private IAwardDao awardDao;
    @Resource
    private IStrategyDao strategyDao;
    @Resource
    private IStrategyDetailDao strategyDetailDao;

    @Override
    public void addActivity(ActivityVO activity) {
        Activity req = new Activity();
        BeanUtils.copyProperties(activity, req);
        activityDao.insert(req);
    }

    @Override
    public void addAward(List<AwardVO> awardList) {
        List<Award> req = new ArrayList<>();
        for (AwardVO awardVO : awardList) {
            Award award = new Award();
            BeanUtils.copyProperties(awardVO, award);
            req.add(award);
        }
        awardDao.insertList(req);
    }

    @Override
    public void addStrategy(StrategyVO strategy) {
        Strategy req = new Strategy();
        BeanUtils.copyProperties(strategy, req);
        strategyDao.insert(req);
    }

    @Override
    public void addStrategyDetailList(List<StrategyDetailVO> strategyDetailList) {
        List<StrategyDetail> req = new ArrayList<>();
        for (StrategyDetailVO strategyDetailVO : strategyDetailList) {
            StrategyDetail strategyDetail = new StrategyDetail();
            BeanUtils.copyProperties(strategyDetailVO, strategyDetail);
            req.add(strategyDetail);
        }
        strategyDetailDao.insertList(req);
    }

    @Override
    public boolean alterStatus(Long activityId, Enum<Constants.ActivityState> beforeState, Enum<Constants.ActivityState> afterState) {
        AlterStateVO alterStateVO = new AlterStateVO(activityId, ((Constants.ActivityState) beforeState).getCode(), ((Constants.ActivityState) afterState).getCode());
        int count = activityDao.alterState(alterStateVO);
        return 1 == count;
    }
}

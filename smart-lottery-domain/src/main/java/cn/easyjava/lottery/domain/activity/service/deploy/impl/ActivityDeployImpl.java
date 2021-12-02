package cn.easyjava.lottery.domain.activity.service.deploy.impl;


import cn.easyjava.lottery.domain.activity.model.aggregates.ActivityConfigRich;
import cn.easyjava.lottery.domain.activity.model.req.ActivityConfigReq;
import cn.easyjava.lottery.domain.activity.model.vo.ActivityVO;
import cn.easyjava.lottery.domain.activity.model.vo.AwardVO;
import cn.easyjava.lottery.domain.activity.model.vo.StrategyDetailVO;
import cn.easyjava.lottery.domain.activity.model.vo.StrategyVO;
import cn.easyjava.lottery.domain.activity.repository.IActivityRepository;
import cn.easyjava.lottery.domain.activity.service.deploy.IActivityDeploy;
import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.yaml.snakeyaml.constructor.DuplicateKeyException;

import javax.annotation.Resource;
import java.util.List;

/**
 * Description: 部署活动配置服务
 * <br/>
 * ActivityDeployImpl
 *
 * @author laiql
 * @date 2021/12/2 15:34
 */
@Service
public class ActivityDeployImpl implements IActivityDeploy {

    private Logger logger = LoggerFactory.getLogger(ActivityDeployImpl.class);

    @Resource
    private IActivityRepository activityRepository;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void createActivity(ActivityConfigReq req) {
        logger.info("创建活动配置开始，activityId：{}", req.getActivityId());
        ActivityConfigRich activityConfigRich = req.getActivityConfigRich();
        try {
            // 添加活动配置
            ActivityVO activity = activityConfigRich.getActivity();
            activityRepository.addActivity(activity);

            // 添加奖品配置
            List<AwardVO> awardList = activityConfigRich.getAwardList();
            activityRepository.addAward(awardList);

            // 添加策略配置
            StrategyVO strategy = activityConfigRich.getStrategy();
            activityRepository.addStrategy(strategy);

            // 添加策略明细配置
            List<StrategyDetailVO> strategyDetailList = activityConfigRich.getStrategy().getStrategyDetailList();
            activityRepository.addStrategyDetailList(strategyDetailList);

            logger.info("创建活动配置完成，activityId：{}", req.getActivityId());
        } catch (DuplicateKeyException e) {
            logger.error("创建活动配置失败，唯一索引冲突 activityId：{} reqJson：{}", req.getActivityId(), JSONUtil.toJsonStr(req), e);
            throw e;
        }
    }

    @Override
    public void updateActivity(ActivityConfigReq req) {
        // TODO: 非核心功能后续补充
    }

}

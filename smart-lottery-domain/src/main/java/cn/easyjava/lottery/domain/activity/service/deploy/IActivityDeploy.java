package cn.easyjava.lottery.domain.activity.service.deploy;

import cn.easyjava.lottery.domain.activity.model.req.ActivityConfigReq;

/**
 * Description: 部署活动配置接口
 * <br/>
 * IActivityDeploy
 *
 * @author laiql
 * @date 2021/12/2 15:25
 */
public interface IActivityDeploy {

    /**
     * 创建活动信息
     *
     * @param req 活动配置信息
     */
    void createActivity(ActivityConfigReq req);

    /**
     * 修改活动信息
     *
     * @param req 活动配置信息
     */
    void updateActivity(ActivityConfigReq req);
}

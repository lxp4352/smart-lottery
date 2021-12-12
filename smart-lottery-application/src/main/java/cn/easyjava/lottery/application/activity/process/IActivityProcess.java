package cn.easyjava.lottery.application.activity.process;

import cn.easyjava.lottery.application.activity.process.req.DrawProcessReq;
import cn.easyjava.lottery.application.activity.process.resp.DrawProcessResult;
import cn.easyjava.lottery.application.activity.process.resp.RuleQuantificationCrowdResult;
import cn.easyjava.lottery.domain.rule.model.req.DecisionMatterReq;

/**
 * Description: 抽奖活动流程编排
 * <br/>
 * IActivityProcess
 *
 * @author laiql
 * @date 2021/12/11 3:43 下午
 */
public interface IActivityProcess {

    /**
     * 执行抽奖流程
     * @param req 抽奖请求
     * @return    抽奖结果
     */
    DrawProcessResult doDrawProcess(DrawProcessReq req);

    /**
     * 规则量化人群，返回可参与的活动ID
     * @param req   规则请求
     * @return      量化结果，用户可以参与的活动ID
     */
    RuleQuantificationCrowdResult doRuleQuantificationCrowd(DecisionMatterReq req);
}

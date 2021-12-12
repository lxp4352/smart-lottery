package cn.easyjava.lottery.domain.rule.service.engine;


import cn.easyjava.lottery.domain.rule.model.req.DecisionMatterReq;
import cn.easyjava.lottery.domain.rule.model.resp.EngineResult;

/**
 * Description: 规则过滤器引擎
 * <br/>
 * EngineFilter
 *
 * @author laiql
 * @date 2021/12/12 8:21 下午
 */
public interface EngineFilter {

    /**
     * 规则过滤器接口
     *
     * @param matter 规则决策物料
     * @return 规则决策结果
     */
    EngineResult process(final DecisionMatterReq matter);

}

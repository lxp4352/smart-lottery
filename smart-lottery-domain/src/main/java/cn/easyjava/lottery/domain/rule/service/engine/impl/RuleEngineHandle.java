package cn.easyjava.lottery.domain.rule.service.engine.impl;


import cn.easyjava.lottery.domain.rule.model.aggregates.TreeRuleRich;
import cn.easyjava.lottery.domain.rule.model.req.DecisionMatterReq;
import cn.easyjava.lottery.domain.rule.model.resp.EngineResult;
import cn.easyjava.lottery.domain.rule.model.vo.TreeNodeVO;
import cn.easyjava.lottery.domain.rule.repository.IRuleRepository;
import cn.easyjava.lottery.domain.rule.service.engine.EngineBase;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Description: 规则引擎处理器
 * <br/>
 * RuleEngineHandle
 *
 * @author laiql
 * @date 2021/12/12 8:22 下午
 */
@Service("ruleEngineHandle")
public class RuleEngineHandle extends EngineBase {

    @Resource
    private IRuleRepository ruleRepository;

    @Override
    public EngineResult process(DecisionMatterReq matter) {
        // 决策规则树
        TreeRuleRich treeRuleRich = ruleRepository.queryTreeRuleRich(matter.getTreeId());
        if (null == treeRuleRich) {
            throw new RuntimeException("Tree Rule is null!");
        }

        // 决策节点
        TreeNodeVO treeNodeInfo = engineDecisionMaker(treeRuleRich, matter);

        // 决策结果
        return new EngineResult(matter.getUserId(), treeNodeInfo.getTreeId(), treeNodeInfo.getTreeNodeId(), treeNodeInfo.getNodeValue());
    }

}

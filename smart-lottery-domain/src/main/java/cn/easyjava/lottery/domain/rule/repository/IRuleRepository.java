package cn.easyjava.lottery.domain.rule.repository;

import cn.easyjava.lottery.domain.rule.model.aggregates.TreeRuleRich;

/**
 * Description: 规则信息仓储服务接口
 * <br/>
 * IRuleRepository
 *
 * @author laiql
 * @date 2021/12/12 8:16 下午
 */
public interface IRuleRepository {

    /**
     * 查询规则决策树配置
     *
     * @param treeId 决策树ID
     * @return 决策树配置
     */
    TreeRuleRich queryTreeRuleRich(Long treeId);

}

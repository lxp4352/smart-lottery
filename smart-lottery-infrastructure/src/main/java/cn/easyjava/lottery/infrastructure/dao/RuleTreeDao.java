package cn.easyjava.lottery.infrastructure.dao;


import cn.easyjava.lottery.infrastructure.po.RuleTree;

/**
 * Description: 规则树配置DAO
 * <br/>
 * RuleTreeDao
 *
 * @author laiql
 * @date 2021/12/12 8:32 下午
 */
public interface RuleTreeDao {

    /**
     * 规则树查询
     * @param id ID
     * @return   规则树
     */
    RuleTree queryRuleTreeByTreeId(Long id);

    /**
     * 规则树简要信息查询
     * @param treeId 规则树ID
     * @return       规则树
     */
    RuleTree queryTreeSummaryInfo(Long treeId);

}

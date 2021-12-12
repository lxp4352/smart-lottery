package cn.easyjava.lottery.infrastructure.dao;

import cn.easyjava.lottery.infrastructure.po.RuleTreeNode;

import java.util.List;

/**
 * Description: 规则树节点DAO
 * <br/>
 * RuleTreeNodeDao
 *
 * @author laiql
 * @date 2021/12/12 8:32 下午
 */
public interface RuleTreeNodeDao {

    /**
     * 查询规则树节点
     *
     * @param treeId 规则树ID
     * @return 规则树节点集合
     */
    List<RuleTreeNode> queryRuleTreeNodeList(Long treeId);

    /**
     * 查询规则树节点数量
     *
     * @param treeId 规则树ID
     * @return 节点数量
     */
    int queryTreeNodeCount(Long treeId);

    /**
     * 查询规则树节点
     *
     * @param treeId 规则树ID
     * @return 节点集合
     */
    List<RuleTreeNode> queryTreeRulePoint(Long treeId);

}

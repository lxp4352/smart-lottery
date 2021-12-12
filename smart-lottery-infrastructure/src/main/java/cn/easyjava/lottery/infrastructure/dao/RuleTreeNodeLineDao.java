package cn.easyjava.lottery.infrastructure.dao;

import cn.easyjava.lottery.infrastructure.po.RuleTreeNodeLine;

import java.util.List;

/**
 * Description: 规则树节点连线DAO
 * <br/>
 * RuleTreeNodeLineDao
 *
 * @author laiql
 * @date 2021/12/12 8:33 下午
 */
public interface RuleTreeNodeLineDao {

    /**
     * 查询规则树节点连线集合
     *
     * @param req 入参
     * @return 规则树节点连线集合
     */
    List<RuleTreeNodeLine> queryRuleTreeNodeLineList(RuleTreeNodeLine req);

    /**
     * 查询规则树连线数量
     *
     * @param treeId 规则树ID
     * @return 规则树连线数量
     */
    int queryTreeNodeLineCount(Long treeId);

}

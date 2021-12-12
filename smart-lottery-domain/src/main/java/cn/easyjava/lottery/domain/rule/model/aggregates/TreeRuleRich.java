package cn.easyjava.lottery.domain.rule.model.aggregates;


import cn.easyjava.lottery.domain.rule.model.vo.TreeNodeVO;
import cn.easyjava.lottery.domain.rule.model.vo.TreeRootVO;

import java.util.Map;

/**
 * Description: 规则树聚合对象
 * <br/>
 * TreeRuleRich
 *
 * @author laiql
 * @date 2021/12/12 8:16 下午
 */
public class TreeRuleRich {

    /**
     * 树根信息
     */
    private TreeRootVO treeRoot;
    /**
     * 树节点ID -> 子节点
     */
    private Map<Long, TreeNodeVO> treeNodeMap;

    public TreeRootVO getTreeRoot() {
        return treeRoot;
    }

    public void setTreeRoot(TreeRootVO treeRoot) {
        this.treeRoot = treeRoot;
    }

    public Map<Long, TreeNodeVO> getTreeNodeMap() {
        return treeNodeMap;
    }

    public void setTreeNodeMap(Map<Long, TreeNodeVO> treeNodeMap) {
        this.treeNodeMap = treeNodeMap;
    }
}

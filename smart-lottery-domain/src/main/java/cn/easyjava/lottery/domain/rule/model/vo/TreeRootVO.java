package cn.easyjava.lottery.domain.rule.model.vo;

/**
 * Description: 规则树根配置
 * <br/>
 * TreeRootVO
 *
 * @author laiql
 * @date 2021/12/12 8:14 下午
 */
public class TreeRootVO {

    /**
     * 规则树ID
     */
    private Long treeId;
    /**
     * 规则树根ID
     */
    private Long treeRootNodeId;
    /**
     * 规则树名称
     */
    private String treeName;

    public Long getTreeId() {
        return treeId;
    }

    public void setTreeId(Long treeId) {
        this.treeId = treeId;
    }

    public Long getTreeRootNodeId() {
        return treeRootNodeId;
    }

    public void setTreeRootNodeId(Long treeRootNodeId) {
        this.treeRootNodeId = treeRootNodeId;
    }

    public String getTreeName() {
        return treeName;
    }

    public void setTreeName(String treeName) {
        this.treeName = treeName;
    }

    @Override
    public String toString() {
        return "TreeRootVO{" +
                "treeId=" + treeId +
                ", treeRootNodeId=" + treeRootNodeId +
                ", treeName='" + treeName + '\'' +
                '}';
    }
}

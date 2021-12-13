package cn.easyjava.lottery.rpc.req;

import java.io.Serializable;
import java.util.Map;

/**
 * Description: 量化人群抽奖请求参数
 * <br/>
 * QuantificationDrawReq
 *
 * @author laiql
 * @date 2021/12/12 9:09 下午
 */
public class QuantificationDrawReq implements Serializable {

    /**
     * 用户ID
     */
    private String userId;
    /**
     * 规则树ID
     */
    private Long treeId;
    /**
     * 决策值
     */
    private Map<String, Object> valMap;

    public Long getTreeId() {
        return treeId;
    }

    public void setTreeId(Long treeId) {
        this.treeId = treeId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Map<String, Object> getValMap() {
        return valMap;
    }

    public void setValMap(Map<String, Object> valMap) {
        this.valMap = valMap;
    }

}

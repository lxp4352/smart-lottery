package cn.easyjava.lottery.domain.rule.service.logic;


import cn.easyjava.lottery.domain.rule.model.req.DecisionMatterReq;
import cn.easyjava.lottery.domain.rule.model.vo.TreeNodeLineVO;

import java.util.List;

/**
 * Description: 规则过滤器接口
 * <br/>
 * LogicFilter
 *
 * @author laiql
 * @date 2021/12/12 8:18 下午
 */
public interface LogicFilter {

    /**
     * 逻辑决策器
     *
     * @param matterValue          决策值
     * @param treeNodeLineInfoList 决策节点
     * @return 下一个节点Id
     */
    Long filter(String matterValue, List<TreeNodeLineVO> treeNodeLineInfoList);

    /**
     * 获取决策值
     *
     * @param decisionMatter 决策物料
     * @return 决策值
     */
    String matterValue(DecisionMatterReq decisionMatter);

}

package cn.easyjava.lottery.domain.rule.service.logic.impl;

import cn.easyjava.lottery.domain.rule.model.req.DecisionMatterReq;
import cn.easyjava.lottery.domain.rule.service.logic.BaseLogic;
import org.springframework.stereotype.Component;

/**
 * Description: 年龄规则过滤
 * <br/>
 * UserAgeFilter
 *
 * @author laiql
 * @date 2021/12/12 8:20 下午
 */
@Component
public class UserAgeFilter extends BaseLogic {

    @Override
    public String matterValue(DecisionMatterReq decisionMatter) {
        return decisionMatter.getValMap().get("age").toString();
    }

}

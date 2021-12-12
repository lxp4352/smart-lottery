package cn.easyjava.lottery.domain.rule.service.logic.impl;


import cn.easyjava.lottery.domain.rule.model.req.DecisionMatterReq;
import cn.easyjava.lottery.domain.rule.service.logic.BaseLogic;
import org.springframework.stereotype.Component;

/**
 * Description: 性别规则过滤
 * <br/>
 * UserGenderFilter
 *
 * @author laiql
 * @date 2021/12/12 8:19 下午
 */
@Component
public class UserGenderFilter extends BaseLogic {

    @Override
    public String matterValue(DecisionMatterReq decisionMatter) {
        return decisionMatter.getValMap().get("gender").toString();
    }

}

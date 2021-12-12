package cn.easyjava.lottery.domain.rule.service.engine;


import cn.easyjava.lottery.domain.rule.service.logic.LogicFilter;
import cn.easyjava.lottery.domain.rule.service.logic.impl.UserAgeFilter;
import cn.easyjava.lottery.domain.rule.service.logic.impl.UserGenderFilter;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Description: 规则配置
 * <br/>
 * EngineConfig
 *
 * @author laiql
 * @date 2021/12/12 8:20 下午
 */
public class EngineConfig {

    protected static Map<String, LogicFilter> logicFilterMap = new ConcurrentHashMap<>();

    @Resource
    private UserAgeFilter userAgeFilter;
    @Resource
    private UserGenderFilter userGenderFilter;

    @PostConstruct
    public void init() {
        logicFilterMap.put("userAge", userAgeFilter);
        logicFilterMap.put("userGender", userGenderFilter);
    }

}

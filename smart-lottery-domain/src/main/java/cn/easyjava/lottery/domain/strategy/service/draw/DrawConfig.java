package cn.easyjava.lottery.domain.strategy.service.draw;

import cn.easyjava.lottery.domain.strategy.service.algorithm.IDrawAlgorithm;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Description: 抽奖配置
 * <br/>
 * DrawConfig
 *
 * @author laiql
 * @date 2021/12/1 10:36
 */
public class DrawConfig {
    @Resource
    private IDrawAlgorithm defaultRateRandomDrawAlgorithm;
    @Resource
    private IDrawAlgorithm singleRateRandomDrawAlgorithm;

    /**
     * 抽奖策略组
     */
    protected static Map<Integer, IDrawAlgorithm> drawAlgorithmMap = new ConcurrentHashMap<>();

    @PostConstruct
    public void init() {
        drawAlgorithmMap.put(1, defaultRateRandomDrawAlgorithm);
        drawAlgorithmMap.put(2, singleRateRandomDrawAlgorithm);
    }
}

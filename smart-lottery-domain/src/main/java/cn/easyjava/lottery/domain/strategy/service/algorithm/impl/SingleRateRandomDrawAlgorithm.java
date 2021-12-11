package cn.easyjava.lottery.domain.strategy.service.algorithm.impl;

import cn.easyjava.lottery.domain.strategy.service.algorithm.BaseAlgorithm;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.util.List;

/**
 * Description: 【推荐】单项随机概率抽奖，抽到一个已经排掉的奖品则未中奖
 * <br/>
 * SingleRateRandomDrawAlgorithm
 *
 * @author laiql
 * @date 2021/12/1 10:33
 */
@Component("singleRateRandomDrawAlgorithm")
public class SingleRateRandomDrawAlgorithm extends BaseAlgorithm {

    @Override
    public String randomDraw(Long strategyId, List<String> excludeAwardIds) {

        // 获取策略对应的元祖
        String[] rateTuple = super.rateTupleMap.get(strategyId);
        assert rateTuple != null;

        // 随机索引
        int randomVal = this.generateSecureRandomIntCode(100);
        int idx = super.hashIdx(randomVal);

        // 返回结果
        String awardId = rateTuple[idx];
        if (excludeAwardIds.contains(awardId)) {
            return "未中奖";
        }

        return awardId;
    }

}

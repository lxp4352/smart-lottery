package cn.easyjava.lottery.domain.strategy.service.algorithm.impl;

import cn.easyjava.lottery.domain.strategy.model.vo.AwardRateInfoVO;
import cn.easyjava.lottery.domain.strategy.service.algorithm.BaseAlgorithm;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

/**
 * Description: 必中奖策略抽奖，排掉已经中奖的概率，重新计算中奖范围
 * <br/>
 * DefaultRateRandomDrawAlgorithm
 *
 * @author laiql
 * @date 2021/12/1 10:30
 */
@Component("defaultRateRandomDrawAlgorithm")
public class DefaultRateRandomDrawAlgorithm extends BaseAlgorithm {

    @Override
    public String randomDraw(Long strategyId, List<String> excludeAwardIds) {

        BigDecimal differenceDenominator = BigDecimal.ZERO;

        // 排除掉不在抽奖范围的奖品ID集合
        List<AwardRateInfoVO> differenceAwardRateList = new ArrayList<>();
        List<AwardRateInfoVO> awardRateIntervalValList = awardRateInfoMap.get(strategyId);
        for (AwardRateInfoVO awardRateInfo : awardRateIntervalValList) {
            String awardId = awardRateInfo.getAwardId();
            if (excludeAwardIds.contains(awardId)) {
                continue;
            }
            differenceAwardRateList.add(awardRateInfo);
            differenceDenominator = differenceDenominator.add(awardRateInfo.getAwardRate());
        }

        // 前置判断
        if (differenceAwardRateList.size() == 0) return "";
        if (differenceAwardRateList.size() == 1) return differenceAwardRateList.get(0).getAwardId();

        // 获取随机概率值
        SecureRandom secureRandom = new SecureRandom();
        int randomVal = secureRandom.nextInt(100) + 1;

        // 循环获取奖品
        String awardId = "";
        int cursorVal = 0;
        for (AwardRateInfoVO awardRateInfoVO : differenceAwardRateList) {
            int rateVal = awardRateInfoVO.getAwardRate().divide(differenceDenominator, 2, BigDecimal.ROUND_UP).multiply(new BigDecimal(100)).intValue();
            if (randomVal <= (cursorVal + rateVal)) {
                awardId = awardRateInfoVO.getAwardId();
                break;
            }
            cursorVal += rateVal;
        }

        // 返回中奖结果
        return awardId;
    }

}
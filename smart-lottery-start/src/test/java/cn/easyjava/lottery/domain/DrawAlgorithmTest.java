package cn.easyjava.lottery.domain;

import cn.easyjava.lottery.domain.strategy.model.vo.AwardRateInfoVO;
import cn.easyjava.lottery.domain.strategy.service.algorithm.IDrawAlgorithm;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DrawAlgorithmTest {

    //    @Resource(name = "defaultRateRandomDrawAlgorithm")
    @Resource(name = "singleRateRandomDrawAlgorithm")
    private IDrawAlgorithm randomDrawAlgorithm;

    @Before
    public void init() {
        // 奖品信息
        List<AwardRateInfoVO> strategyList = new ArrayList<>();
        strategyList.add(new AwardRateInfoVO("一等奖：IMac", new BigDecimal("0.05")));
        strategyList.add(new AwardRateInfoVO("二等奖：iphone", new BigDecimal("0.15")));
        strategyList.add(new AwardRateInfoVO("三等奖：ipad", new BigDecimal("0.20")));
        strategyList.add(new AwardRateInfoVO("四等奖：AirPods", new BigDecimal("0.25")));
        strategyList.add(new AwardRateInfoVO("五等奖：充电宝", new BigDecimal("0.35")));

        // 初始数据
        randomDrawAlgorithm.initRateTuple(100001L, 1,strategyList);
    }

    @Test
    public void test_randomDrawAlgorithm() {

        List<String> excludeAwardIds = new ArrayList<>();
        excludeAwardIds.add("二等奖：iphone");
        excludeAwardIds.add("四等奖：AirPods");

        for (int i = 0; i < 20; i++) {
            System.out.println("中奖结果：" + randomDrawAlgorithm.randomDraw(100001L, excludeAwardIds));
        }

    }

}

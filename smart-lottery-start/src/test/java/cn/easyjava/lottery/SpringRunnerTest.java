package cn.easyjava.lottery;

import cn.easyjava.lottery.domain.strategy.model.req.DrawRequest;
import cn.easyjava.lottery.domain.strategy.model.vo.AwardRateInfoVO;
import cn.easyjava.lottery.domain.strategy.service.algorithm.IDrawAlgorithm;
import cn.easyjava.lottery.domain.strategy.service.draw.IDrawExec;
import cn.easyjava.lottery.infrastructure.dao.IAwardDao;
import cn.easyjava.lottery.infrastructure.dao.IStrategyDao;
import cn.easyjava.lottery.infrastructure.dao.IStrategyDetailDao;
import cn.easyjava.lottery.infrastructure.po.Award;
import cn.easyjava.lottery.infrastructure.po.Strategy;
import cn.easyjava.lottery.infrastructure.po.StrategyDetail;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringRunnerTest {

    //抽奖算法
    @Resource(name = "singleRateRandomDrawAlgorithm")
    private IDrawAlgorithm randomDrawAlgorithm;
    //奖品
    @Resource
    private IAwardDao awardDao;
    //策略配置
    @Resource
    private IStrategyDao strategyDao;
    //策略配置明细
    @Resource
    private IStrategyDetailDao strategyDetailDao;
    @Resource
    private IDrawExec drawExec;
    //    @Before
    public void init() {
        // 奖品信息
        List<AwardRateInfoVO> strategyList = new ArrayList<>();
        strategyList.add(new AwardRateInfoVO("一等奖：IMac", new BigDecimal("0.05")));
        strategyList.add(new AwardRateInfoVO("二等奖：iphone", new BigDecimal("0.15")));
        strategyList.add(new AwardRateInfoVO("三等奖：ipad", new BigDecimal("0.20")));
        strategyList.add(new AwardRateInfoVO("四等奖：AirPods", new BigDecimal("0.25")));
        strategyList.add(new AwardRateInfoVO("五等奖：充电宝", new BigDecimal("0.35")));

        // 初始数据
        randomDrawAlgorithm.initRateTuple(100001L, strategyList);
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
    @Test
    public void test_drawExec() {
        drawExec.doDrawExec(new DrawRequest("小傅哥", 10001L));
        drawExec.doDrawExec(new DrawRequest("小佳佳", 10001L));
        drawExec.doDrawExec(new DrawRequest("小蜗牛", 10001L));
        drawExec.doDrawExec(new DrawRequest("八杯水", 10001L));
    }
    @Test
    public void testAdd() {
        Award award = new Award();
        award.setAwardId("10003");
        award.setAwardType(3);
        award.setAwardName("ipad");
        award.setAwardContent("apple");
        award.setCreateTime(new Date());
        award.setUpdateTime(new Date());

        awardDao.insert(award);

//        Strategy strategy = new Strategy();
//        strategy.setStrategyId(10001L);
//        strategy.setStrategyDesc("抽奖策略1");
//        strategy.setStrategyMode(1);
//        strategy.setGrantType(3);
//        strategy.setGrantDate(new Date());
//        strategy.setExtInfo("ext");
//        strategy.setCreateTime(new Date());
//        strategy.setUpdateTime(new Date());
//        strategyDao.insert(strategy);

        StrategyDetail strategyDetail = new StrategyDetail();
        strategyDetail.setStrategyId(10001L);
        strategyDetail.setAwardId("10003");
        strategyDetail.setAwardCount("1");
        strategyDetail.setAwardRate(new BigDecimal("0.20"));

        strategyDetailDao.insert(strategyDetail);

    }
}

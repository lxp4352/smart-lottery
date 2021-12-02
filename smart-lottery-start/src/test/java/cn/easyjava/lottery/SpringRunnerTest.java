package cn.easyjava.lottery;

import cn.easyjava.lottery.domain.award.model.req.GoodsReq;
import cn.easyjava.lottery.domain.award.model.resp.DistributionRes;
import cn.easyjava.lottery.domain.award.service.factory.DistributionGoodsFactory;
import cn.easyjava.lottery.domain.award.service.goods.IDistributionGoods;
import cn.easyjava.lottery.domain.common.Constants;
import cn.easyjava.lottery.domain.strategy.model.req.DrawRequest;
import cn.easyjava.lottery.domain.strategy.model.resp.DrawResult;
import cn.easyjava.lottery.domain.strategy.model.vo.AwardRateInfoVO;
import cn.easyjava.lottery.domain.strategy.model.vo.DrawAwardInfoVO;
import cn.easyjava.lottery.domain.strategy.service.algorithm.IDrawAlgorithm;
import cn.easyjava.lottery.domain.strategy.service.draw.IDrawExec;
import cn.easyjava.lottery.infrastructure.award.dao.IAwardDao;
import cn.easyjava.lottery.infrastructure.award.po.Award;
import cn.easyjava.lottery.infrastructure.strategy.dao.IStrategyDao;
import cn.easyjava.lottery.infrastructure.strategy.dao.IStrategyDetailDao;
import cn.easyjava.lottery.infrastructure.strategy.po.StrategyDetail;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    @Resource
    private DistributionGoodsFactory distributionGoodsFactory;

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
        strategyDetail.setAwardCount(1);
        strategyDetail.setAwardRate(new BigDecimal("0.20"));

        strategyDetailDao.insert(strategyDetail);

    }

    @Test
    public void test_award() {
        // 执行抽奖
        DrawResult drawResult = drawExec.doDrawExec(new DrawRequest("Test", 10001L));

        // 判断抽奖结果
        Integer drawState = drawResult.getDrawState();
        if (Constants.DrawState.FAIL.getCode().equals(drawState)) {
            System.out.println("未中奖 DrawAwardInfo is null");
            return;
        }

        // 封装发奖参数，orderId：2109313442431 为模拟ID，需要在用户参与领奖活动时生成
        DrawAwardInfoVO drawAwardInfo = drawResult.getDrawAwardInfoVO();
        GoodsReq goodsReq = new GoodsReq(drawResult.getUserId(), "2109313442431", drawAwardInfo.getAwardId(), drawAwardInfo.getAwardName(), drawAwardInfo.getAwardContent());

        // 根据 awardType 从抽奖工厂中获取对应的发奖服务
        IDistributionGoods distributionGoodsService = distributionGoodsFactory.getDistributionGoodsService(drawAwardInfo.getAwardType());
        DistributionRes distributionRes = distributionGoodsService.doDistribution(goodsReq);

        System.out.println("测试结果：" + JSON.toJSONString(distributionRes));
    }

}

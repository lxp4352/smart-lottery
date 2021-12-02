package cn.easyjava.lottery.domain.award.service.factory;

import cn.easyjava.lottery.domain.award.service.goods.IDistributionGoods;
import cn.easyjava.lottery.domain.award.service.goods.impl.CouponGoods;
import cn.easyjava.lottery.domain.award.service.goods.impl.DescGoods;
import cn.easyjava.lottery.domain.award.service.goods.impl.PhysicalGoods;
import cn.easyjava.lottery.domain.award.service.goods.impl.RedeemCodeGoods;
import cn.easyjava.lottery.domain.common.Constants;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Description: 各类发奖奖品配置类 (有一个弊端，如果奖品方式过多建议放数据库加载)
 * <br/>
 * GoodsConfig
 *
 * @author laiql
 * @date 2021/12/2 11:01
 */
public class GoodsConfig {

    /**
     * 奖品发放策略组
     */
    protected static Map<Integer, IDistributionGoods> goodsMap = new ConcurrentHashMap<>();

    @Resource
    private DescGoods descGoods;

    @Resource
    private RedeemCodeGoods redeemCodeGoods;

    @Resource
    private CouponGoods couponGoods;

    @Resource
    private PhysicalGoods physicalGoods;

    @PostConstruct
    public void init() {
        goodsMap.put(Constants.AwardType.DESC.getCode(), descGoods);
        goodsMap.put(Constants.AwardType.RedeemCodeGoods.getCode(), redeemCodeGoods);
        goodsMap.put(Constants.AwardType.CouponGoods.getCode(), couponGoods);
        goodsMap.put(Constants.AwardType.PhysicalGoods.getCode(), physicalGoods);
    }
}

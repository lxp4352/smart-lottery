package cn.easyjava.lottery.domain.award.service.goods.impl;

import cn.easyjava.lottery.domain.award.model.req.GoodsReq;
import cn.easyjava.lottery.domain.award.model.resp.DistributionRes;
import cn.easyjava.lottery.domain.award.service.goods.AbstractDistribution;
import cn.easyjava.lottery.domain.award.service.goods.IDistributionGoods;
import cn.easyjava.lottery.domain.common.Constants;
import org.springframework.stereotype.Component;

/**
 * Description: 实物奖品
 * <br/>
 * PhysicalGoods
 *
 * @author laiql
 * @date 2021/12/2 11:03
 */
@Component
public class PhysicalGoods extends AbstractDistribution implements IDistributionGoods {
    @Override
    public DistributionRes doDistribution(GoodsReq req) {
        logger.info("模拟调用实物商品发放接口 userId：{} awardContent：{}", req.getUserId(), req.getAwardContent());
        //更新用户领奖结果
        super.updateUserAwardState(req.getUserId(),req.getOrderId(),req.getAwardId(), Constants.AwardState.SUCCESS.getCode(),Constants.AwardState.SUCCESS.getInfo());
        return new DistributionRes(req.getUserId(), Constants.AwardState.SUCCESS.getCode(), Constants.AwardState.SUCCESS.getInfo());
    }
}

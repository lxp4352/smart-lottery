package cn.easyjava.lottery.domain.award.service.factory;

import cn.easyjava.lottery.domain.award.service.goods.IDistributionGoods;
import org.springframework.stereotype.Component;

/**
 * Description: 发奖简单工厂
 * <br/>
 * DistributionGoodsFactory
 *
 * @author laiql
 * @date 2021/12/2 11:02
 */
@Component
public class DistributionGoodsFactory extends GoodsConfig {
    /**
     * 获取工厂内奖品方法实现
     *
     * @param awardType 奖品类型
     * @return class IDistributionGoods
     */
    public IDistributionGoods getDistributionGoodsService(Integer awardType) {
        return goodsMap.get(awardType);
    }
}

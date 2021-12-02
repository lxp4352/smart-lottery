package cn.easyjava.lottery.domain.award.service.goods;

import cn.easyjava.lottery.domain.award.repository.IAwardRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;

/**
 * Description: 抽象配送货物公共操作
 * <br/>
 * AbstractDistribution
 *
 * @author laiql
 * @date 2021/12/2 10:53
 */
public abstract class AbstractDistribution {
    protected Logger logger = LoggerFactory.getLogger(AbstractDistribution.class);

    @Resource
    private IAwardRepository awardRepository;

    protected void updateUserAwardState(String uId, String orderId, String awardId, Integer awardState, String awardStateInfo) {
        // TODO 后期添加更新分库分表中，用户个人的抽奖记录表中奖品发奖状态
        logger.info("TODO 后期添加更新分库分表中，用户个人的抽奖记录表中奖品发奖状态 uId：{}", uId);
    }
}

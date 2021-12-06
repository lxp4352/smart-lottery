package cn.easyjava.lottery.domain.activity.service.partake;

import cn.easyjava.lottery.domain.activity.model.req.PartakeReq;
import cn.easyjava.lottery.domain.activity.model.resp.PartakeResult;

/**
 * Description: 抽奖活动参与接口
 * <br/>
 * IActivityPartake
 *
 * @author laiql
 * @date 2021/12/2 15:25
 */
public interface IActivityPartake {
    /**
     * 参与活动接口
     */
    PartakeResult doPartake(PartakeReq req);
}

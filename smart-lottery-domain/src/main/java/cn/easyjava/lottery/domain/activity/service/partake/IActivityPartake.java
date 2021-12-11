package cn.easyjava.lottery.domain.activity.service.partake;

import cn.easyjava.lottery.domain.activity.model.req.PartakeReq;
import cn.easyjava.lottery.domain.activity.model.resp.PartakeResult;
import cn.easyjava.lottery.domain.activity.model.vo.DrawOrderVO;
import cn.easyjava.lottery.domain.common.Result;

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

    /**
     * 保存奖品单
     * @param drawOrder 奖品单
     * @return          保存结果
     */
    Result recordDrawOrder(DrawOrderVO drawOrder);
}

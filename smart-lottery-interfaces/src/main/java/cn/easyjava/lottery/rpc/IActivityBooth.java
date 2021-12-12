package cn.easyjava.lottery.rpc;

import cn.easyjava.lottery.rpc.req.DrawReq;
import cn.easyjava.lottery.rpc.req.QuantificationDrawReq;
import cn.easyjava.lottery.rpc.res.DrawRes;

/**
 * Description:
 * 活动展台接口
 * 1. 创建活动
 * 2. 更新活动
 * 3. 查询活动
 * <br/>
 * IActivityBooth
 *
 * @author laiql
 * @date 2021/11/29 16:06
 */
public interface IActivityBooth {

    /**
     * 指定活动抽奖
     * @param drawReq 请求参数
     * @return        抽奖结果
     */
    DrawRes doDraw(DrawReq drawReq);

    /**
     * 量化人群抽奖
     * @param quantificationDrawReq 请求参数
     * @return                      抽奖结果
     */
    DrawRes doQuantificationDraw(QuantificationDrawReq quantificationDrawReq);

}

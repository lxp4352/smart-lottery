package cn.easyjava.lottery.application.activity.process;

import cn.easyjava.lottery.application.activity.process.req.DrawProcessReq;
import cn.easyjava.lottery.application.activity.process.resp.DrawProcessResult;

/**
 * Description: 抽奖活动流程编排
 * <br/>
 * IActivityProcess
 *
 * @author laiql
 * @date 2021/12/11 3:43 下午
 */
public interface IActivityProcess {

    /**
     * 执行抽奖流程
     * @param req 抽奖请求
     * @return    抽奖结果
     */
    DrawProcessResult doDrawProcess(DrawProcessReq req);
}

package cn.easyjava.lottery.domain.strategy.service.draw;

import cn.easyjava.lottery.domain.strategy.model.req.DrawRequest;
import cn.easyjava.lottery.domain.strategy.model.resp.DrawResult;

/**
 * Description: 统一抽奖接口
 * <br/>
 * IDrawExec
 *
 * @author laiql
 * @date 2021/11/30 17:45
 */
public interface IDrawExec {

    /**
     * 执行抽奖接口
     *
     * @param request 抽奖请求参数封装
     * @return class DrawResult
     */
    DrawResult doDrawExec(DrawRequest request);
}

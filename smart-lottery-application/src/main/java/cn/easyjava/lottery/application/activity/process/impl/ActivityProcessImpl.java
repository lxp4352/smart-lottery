package cn.easyjava.lottery.application.activity.process.impl;

import cn.easyjava.lottery.application.activity.process.IActivityProcess;
import cn.easyjava.lottery.application.activity.process.req.DrawProcessReq;
import cn.easyjava.lottery.application.activity.process.resp.DrawProcessResult;
import cn.easyjava.lottery.domain.activity.model.req.PartakeReq;
import cn.easyjava.lottery.domain.activity.model.resp.PartakeResult;
import cn.easyjava.lottery.domain.activity.model.vo.DrawOrderVO;
import cn.easyjava.lottery.domain.activity.service.partake.IActivityPartake;
import cn.easyjava.lottery.domain.common.Constants;
import cn.easyjava.lottery.domain.strategy.model.req.DrawRequest;
import cn.easyjava.lottery.domain.strategy.model.resp.DrawResult;
import cn.easyjava.lottery.domain.strategy.model.vo.DrawAwardInfoVO;
import cn.easyjava.lottery.domain.strategy.service.draw.IDrawExec;
import cn.easyjava.lottery.domain.support.ids.IIdGenerator;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Description: 活动抽奖流程编排
 * <br/>
 * ActivityProcessImpl
 *
 * @author laiql
 * @date 2021/12/11 3:49 下午
 */
@Service
public class ActivityProcessImpl implements IActivityProcess {

    @Resource
    private IActivityPartake activityPartake;

    @Resource
    private IDrawExec drawExec;

    @Resource
    private Map<Constants.Ids, IIdGenerator> idGeneratorMap;

    @Override
    public DrawProcessResult doDrawProcess(DrawProcessReq req) {
        // 1. 领取活动
        PartakeResult partakeResult = activityPartake.doPartake(new PartakeReq(req.getUserId(), req.getActivityId()));
        if (!Constants.ResponseCode.SUCCESS.getCode().equals(partakeResult.getCode())) {
            return new DrawProcessResult(partakeResult.getCode(), partakeResult.getInfo());
        }
        Long strategyId = partakeResult.getStrategyId();
        Long takeId = partakeResult.getTakeId();

        // 2. 执行抽奖
        DrawResult drawResult = drawExec.doDrawExec(new DrawRequest(req.getUserId(), strategyId, String.valueOf(takeId)));
        if (Constants.DrawState.FAIL.getCode().equals(drawResult.getDrawState())) {
            return new DrawProcessResult(Constants.ResponseCode.LOSING_DRAW.getCode(), Constants.ResponseCode.LOSING_DRAW.getInfo());
        }
        DrawAwardInfoVO drawAwardInfoVO = drawResult.getDrawAwardInfoVO();

        // 3. 结果落库
        activityPartake.recordDrawOrder(buildDrawOrderVO(req, strategyId, takeId, drawAwardInfoVO));

        // 4. 发送MQ，触发发奖流程

        // 5. 返回结果
        return new DrawProcessResult(Constants.ResponseCode.SUCCESS.getCode(), Constants.ResponseCode.SUCCESS.getInfo(), drawAwardInfoVO);
    }

    private DrawOrderVO buildDrawOrderVO(DrawProcessReq req, Long strategyId, Long takeId, DrawAwardInfoVO drawAwardInfoVO) {
        long orderId = idGeneratorMap.get(Constants.Ids.SnowFlake).nextId();
        DrawOrderVO drawOrderVO = new DrawOrderVO();
        drawOrderVO.setUserId(req.getUserId());
        drawOrderVO.setTakeId(takeId);
        drawOrderVO.setActivityId(req.getActivityId());
        drawOrderVO.setOrderId(orderId);
        drawOrderVO.setStrategyId(strategyId);
        drawOrderVO.setStrategyMode(drawAwardInfoVO.getStrategyMode());
        drawOrderVO.setGrantType(drawAwardInfoVO.getGrantType());
        drawOrderVO.setGrantDate(drawAwardInfoVO.getGrantDate());
        drawOrderVO.setGrantState(Constants.GrantState.INIT.getCode());
        drawOrderVO.setAwardId(drawAwardInfoVO.getAwardId());
        drawOrderVO.setAwardType(drawAwardInfoVO.getAwardType());
        drawOrderVO.setAwardName(drawAwardInfoVO.getAwardName());
        drawOrderVO.setAwardContent(drawAwardInfoVO.getAwardContent());
        return drawOrderVO;
    }
}

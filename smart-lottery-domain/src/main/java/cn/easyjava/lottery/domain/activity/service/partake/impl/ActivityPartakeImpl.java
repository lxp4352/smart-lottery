package cn.easyjava.lottery.domain.activity.service.partake.impl;

import cn.easyjava.lottery.domain.activity.model.req.PartakeReq;
import cn.easyjava.lottery.domain.activity.model.vo.ActivityBillVO;
import cn.easyjava.lottery.domain.activity.model.vo.DrawOrderVO;
import cn.easyjava.lottery.domain.activity.model.vo.UserTakeActivityVO;
import cn.easyjava.lottery.domain.activity.repository.IUserTakeActivityRepository;
import cn.easyjava.lottery.domain.activity.service.partake.AbstractActivityPartakeBase;
import cn.easyjava.lottery.domain.common.Constants;
import cn.easyjava.lottery.domain.common.Result;
import cn.easyjava.lottery.domain.support.ids.IIdGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionTemplate;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Description:活动参与功能实现
 * <br/>
 * ActivityPartakeImpl
 *
 * @author laiql
 * @date 2021/12/6 14:08
 */
@Service
public class ActivityPartakeImpl extends AbstractActivityPartakeBase {
    private Logger logger = LoggerFactory.getLogger(ActivityPartakeImpl.class);

    @Resource
    private IUserTakeActivityRepository userTakeActivityRepository;

    @Resource
    private TransactionTemplate transactionTemplate;

    @Override
    protected Result checkActivityBill(PartakeReq partake, ActivityBillVO bill) {
        // 校验：活动状态
        if (!Constants.ActivityState.DOING.getCode().equals(bill.getState())) {
            logger.warn("活动当前状态非可用 state：{}", bill.getState());
            return Result.buildResult(Constants.ResponseCode.UN_ERROR, "活动当前状态非可用");
        }

        // 校验：活动日期
        if (bill.getBeginDateTime().after(partake.getPartakeDate()) || bill.getEndDateTime().before(partake.getPartakeDate())) {
            logger.warn("活动时间范围非可用 beginDateTime：{} endDateTime：{}", bill.getBeginDateTime(), bill.getEndDateTime());
            return Result.buildResult(Constants.ResponseCode.UN_ERROR, "活动时间范围非可用");
        }

        // 校验：活动库存
        if (bill.getStockSurplusCount() <= 0) {
            logger.warn("活动剩余库存非可用 stockSurplusCount：{}", bill.getStockSurplusCount());
            return Result.buildResult(Constants.ResponseCode.UN_ERROR, "活动剩余库存非可用");
        }

        // 校验：个人库存 - 个人活动剩余可领取次数
        if (bill.getUserTakeLeftCount() <= 0) {
            logger.warn("个人领取次数非可用 userTakeLeftCount：{}", bill.getUserTakeLeftCount());
            return Result.buildResult(Constants.ResponseCode.UN_ERROR, "个人领取次数非可用");
        }

        return Result.buildSuccessResult();
    }

    @Override
    protected Result subtractionActivityStock(PartakeReq req) {
        int count = activityRepository.subtractionActivityStock(req.getActivityId());
        if (0 == count) {
            logger.error("扣减活动库存失败 activityId：{}", req.getActivityId());
            return Result.buildResult(Constants.ResponseCode.NO_UPDATE);
        }
        return Result.buildSuccessResult();
    }

    @Override
    protected Result grabActivity(PartakeReq partake, ActivityBillVO bill,Long takeId) {
        //声明式事务处理
        return transactionTemplate.execute(status -> {
            try {
                // 扣减个人已参与次数
                int updateCount = userTakeActivityRepository.subtractionLeftCount(bill.getActivityId(), bill.getActivityName(), bill.getTakeCount(), bill.getUserTakeLeftCount(), partake.getUserId(), partake.getPartakeDate());
                if (0 == updateCount) {
                    status.setRollbackOnly();
                    logger.error("领取活动，扣减个人已参与次数失败 activityId：{} userId：{}", partake.getActivityId(), partake.getUserId());
                    return Result.buildResult(Constants.ResponseCode.NO_UPDATE);
                }

                // 写入领取活动记录
                userTakeActivityRepository.takeActivity(bill.getActivityId(), bill.getActivityName(), bill.getStrategyId(), bill.getTakeCount(), bill.getUserTakeLeftCount(), partake.getUserId(), partake.getPartakeDate(), takeId);
            } catch (DuplicateKeyException e) {
                status.setRollbackOnly();
                logger.error("领取活动，唯一索引冲突 activityId：{} userId：{}", partake.getActivityId(), partake.getUserId(), e);
                return Result.buildResult(Constants.ResponseCode.INDEX_DUP);
            }
            return Result.buildSuccessResult();
        });
    }

    @Override
    protected UserTakeActivityVO queryNoConsumedTakeActivityOrder(Long activityId, String userId) {
        return userTakeActivityRepository.queryNoConsumedTakeActivityOrder(activityId, userId);
    }

    @Override
    public Result recordDrawOrder(DrawOrderVO drawOrder) {
        return transactionTemplate.execute(status -> {
            try {
                // 锁定活动领取记录
                int lockCount = userTakeActivityRepository.lockTackActivity(drawOrder.getUserId(), drawOrder.getActivityId(), drawOrder.getTakeId());
                if (0 == lockCount) {
                    status.setRollbackOnly();
                    logger.error("记录中奖单，个人参与活动抽奖已消耗完 activityId：{} userId：{}", drawOrder.getActivityId(), drawOrder.getUserId());
                    return Result.buildResult(Constants.ResponseCode.NO_UPDATE);
                }

                // 保存抽奖信息
                userTakeActivityRepository.saveUserStrategyExport(drawOrder);
            } catch (DuplicateKeyException e) {
                status.setRollbackOnly();
                logger.error("记录中奖单，唯一索引冲突 activityId：{} userId：{}", drawOrder.getActivityId(), drawOrder.getUserId(), e);
                return Result.buildResult(Constants.ResponseCode.INDEX_DUP);
            }
            return Result.buildSuccessResult();
        });
    }
}

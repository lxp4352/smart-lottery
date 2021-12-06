package cn.easyjava.lottery.domain.activity.service.partake;

import cn.easyjava.lottery.domain.activity.model.req.PartakeReq;
import cn.easyjava.lottery.domain.activity.model.vo.ActivityBillVO;
import cn.easyjava.lottery.domain.activity.repository.IActivityRepository;

import javax.annotation.Resource;

/**
 * Description: 活动领取模操作，一些通用的数据服务
 * <br/>
 * ActivityPartakeSupport
 *
 * @author laiql
 * @date 2021/12/6 14:10
 */
public class ActivityPartakeSupport {

    @Resource
    protected IActivityRepository activityRepository;

    /***
     * 查询活动账单操作
     * @param req 请求参数
     * @return
     */
    protected ActivityBillVO queryActivityBill(PartakeReq req) {
        return activityRepository.queryActivityBill(req);
    }
}

package cn.easyjava.lottery.infrastructure.dao;

import cn.bugstack.middleware.db.router.annotation.DBRouter;
import cn.easyjava.lottery.infrastructure.po.UserTakeActivityCount;

/**
 * Description: 用户参与活动Dao
 * <br/>
 * IUserTakeActivityCountDao
 *
 * @author laiql
 * @date 2021/12/6 11:42
 */
public interface IUserTakeActivityCountDao {
    /**
     * 查询用户领取次数信息
     *
     * @param userTakeActivityCountReq 请求入参【活动号、用户ID】
     * @return 领取结果
     * @DBRouter 分库不分表
     */
    @DBRouter
    UserTakeActivityCount queryUserTakeActivityCount(UserTakeActivityCount userTakeActivityCountReq);

    /**
     * 插入领取次数信息
     *
     * @param userTakeActivityCount 请求入参
     */
    //@DBRouter
    void addUserTakeActivityCount(UserTakeActivityCount userTakeActivityCount);

    /**
     * 更新领取次数信息
     *
     * @param userTakeActivityCount 请求入参
     * @return 更新数量
     */
    //@DBRouter
    int updateLeftCount(UserTakeActivityCount userTakeActivityCount);
}

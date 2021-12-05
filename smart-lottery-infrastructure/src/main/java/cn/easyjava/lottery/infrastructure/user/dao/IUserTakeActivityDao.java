package cn.easyjava.lottery.infrastructure.user.dao;

import cn.bugstack.middleware.db.router.annotation.DBRouter;
import cn.easyjava.lottery.infrastructure.user.po.UserTakeActivity;

/**
 * Description: 用户领取活动表Dao
 * <br/>
 * IUserTakeActivityDao
 *
 * @author laiql
 * @date 2021/12/5 3:36 下午
 */
public interface IUserTakeActivityDao {

    /**
     * 插入用户领取活动信息
     *
     * @param userTakeActivity 入参
     */
    @DBRouter(key = "userId")
    void addUserTakeActivity(UserTakeActivity userTakeActivity);

}

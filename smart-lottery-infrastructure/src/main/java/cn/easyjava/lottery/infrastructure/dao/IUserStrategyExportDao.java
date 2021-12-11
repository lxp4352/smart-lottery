package cn.easyjava.lottery.infrastructure.dao;

import cn.bugstack.middleware.db.router.annotation.DBRouter;
import cn.bugstack.middleware.db.router.annotation.DBRouterStrategy;
import cn.easyjava.lottery.infrastructure.po.UserStrategyExport;

/**
 * Description: 用户策略计算结果表Dao
 * <br/>
 * IUserStrategyExportDao
 *
 * @author laiql
 * @date 2021/12/5 3:37 下午
 */
@DBRouterStrategy(splitTable = true)
public interface IUserStrategyExportDao {

    /**
     * 新增数据
     *
     * @param userStrategyExport 用户策略
     */
    @DBRouter(key = "userId")
    void addUserStrategyExport(UserStrategyExport userStrategyExport);

    /**
     * 查询数据
     *
     * @param userId 用户ID
     * @return 用户策略
     */
    @DBRouter
    UserStrategyExport queryUserStrategyExportByUId(String userId);
}

package cn.easyjava.lottery.domain;

import cn.easyjava.lottery.infrastructure.dao.IUserTakeActivityDao;
import cn.easyjava.lottery.infrastructure.po.UserTakeActivity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Description: 分库分表测试
 * <br/>
 * DbRouterTest
 *
 * @author laiql
 * @date 2021/12/5 3:26 下午
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DbRouterTest {

    @Resource
    private IUserTakeActivityDao userTakeActivityDao;

    @Test
    public void test_insert() {
        UserTakeActivity userTakeActivity = new UserTakeActivity();
        userTakeActivity.setUserId("Ukdli109op811d"); // 1库：Ukdli109op89oi 2库：Ukdli109op811d
        userTakeActivity.setTakeId(121019889410L);
        userTakeActivity.setActivityId(100001L);
        userTakeActivity.setActivityName("测试活动");
        userTakeActivity.setTakeDate(new Date());
        userTakeActivity.setTakeCount(10);
        userTakeActivity.setUuid("Ukdli109op811d");

        userTakeActivityDao.addUserTakeActivity(userTakeActivity);
    }
}

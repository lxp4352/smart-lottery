package cn.easyjava.lottery.domain;

import cn.easyjava.lottery.domain.common.Constants;
import cn.easyjava.lottery.domain.support.ids.IIdGenerator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Map;


/**
 * Description: ID生成策略测试
 * <br/>
 * SupportIdsTest
 *
 * @author laiql
 * @date 2021/12/5 2:02 下午
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SupportIdsTest {

    private Logger logger = LoggerFactory.getLogger(SupportIdsTest.class);

    @Resource
    private Map<Constants.Ids, IIdGenerator> idGenerator;

    @Test
    public void test(){
        logger.info("雪花算法ID生成：{}",idGenerator.get(Constants.Ids.SnowFlake).nextId());
        logger.info("日期算法ID生成：{}",idGenerator.get(Constants.Ids.ShortCode).nextId());
        logger.info("随机算法ID生成：{}",idGenerator.get(Constants.Ids.RandomNumeric).nextId());
    }

}

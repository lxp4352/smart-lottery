package cn.easyjava.lottery.domain.support.ids.policy;

import cn.easyjava.lottery.domain.support.ids.IIdGenerator;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;

/**
 * Description: 基于Apache-commons工具类生成ID
 * <br/>
 * RandomNumeric
 *
 * @author laiql
 * @date 2021/12/5 1:54 下午
 */
@Component
public class RandomNumeric implements IIdGenerator {

    @Override
    public long nextId() {
        return Long.parseLong(RandomStringUtils.randomNumeric(11));
    }

}

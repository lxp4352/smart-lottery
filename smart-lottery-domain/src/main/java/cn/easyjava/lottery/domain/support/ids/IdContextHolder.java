package cn.easyjava.lottery.domain.support.ids;

import cn.easyjava.lottery.domain.common.Constants;
import cn.easyjava.lottery.domain.support.ids.policy.RandomNumeric;
import cn.easyjava.lottery.domain.support.ids.policy.ShortCode;
import cn.easyjava.lottery.domain.support.ids.policy.SnowFlake;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: ID生成上下文
 * <br/>
 * IdContextHolder
 *
 * @author laiql
 * @date 2021/12/5 1:55 下午
 */
@Configuration
public class IdContextHolder {


    /**
     * 创建 ID 生成策略对象，属于策略设计模式的使用方式
     *
     * @param snowFlake 雪花算法，长码，大量
     * @param shortCode 日期算法，短码，少量，全局唯一需要自己保证
     * @param randomNumeric 随机算法，短码，大量，全局唯一需要自己保证
     * @return IIdGenerator 实现类
     */
    @Bean
    public Map<Constants.Ids,IIdGenerator> idsIIdGenerator(SnowFlake snowFlake, ShortCode shortCode, RandomNumeric randomNumeric){
        Map<Constants.Ids,IIdGenerator> idsIIdGeneratorMap = new HashMap<>(8);
        idsIIdGeneratorMap.put(Constants.Ids.SnowFlake,snowFlake);
        idsIIdGeneratorMap.put(Constants.Ids.ShortCode,shortCode);
        idsIIdGeneratorMap.put(Constants.Ids.RandomNumeric,randomNumeric);
        return idsIIdGeneratorMap;
    }
}

package cn.easyjava.lottery;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Description: 启动器
 * <br/>
 * SmartLotteryApplication
 *
 * @author laiql
 * @date 2021/11/29 15:44
 */
@SpringBootApplication
@Configurable
@EnableDubbo
public class SmartLotteryApplication {
    public static void main(String[] args) {
        SpringApplication.run(SmartLotteryApplication.class, args);
    }
}

package com.kn.springbootlearn;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableRabbit//开启基于注解的rabbitmq
@MapperScan("com.kn.springbootlearn.mapper")
@SpringBootApplication
@EnableCaching//开启基于注解的缓存
@EnableAsync//开启异步注解
@EnableScheduling//开启定时任务
public class SpringbootLearnApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootLearnApplication.class, args);
    }

}

package com.springboot.actualcombat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *  @SpringBootApplication组合注解主要组合了@SpringBootConfiguration、
 *  @EnableAutoConfiguration、@componentScan若不用@SpringBootApplication
 *  则在入口类加入相应注解就行。
 *  @EnableAutoConfiguration让Spring Boot根据类路径的jar包依赖为当前项目进行自动配置
 *
 *  关闭特定的配置使用@SpringBootApplication注解的exclude参数
 * @author Future
 */
@SpringBootApplication
public class ActualcombatApplication {

    public static void main(String[] args) {
        SpringApplication.run(ActualcombatApplication.class, args);
    }
}

package com.springboot.actualcombat.spring1base.aop.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * 配置类
 * 使用@EnableAspectJAutoProxy注解开启spring对AspectJ代理的注解支持
 *
 * @author Future
 */
@Configuration
@ComponentScan(value = "com.springboot.actualcombat.spring1base.aop")
@EnableAspectJAutoProxy
public class AopConfig {

}

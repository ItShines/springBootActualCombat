package com.springboot.actualcombat.springbase.ioc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 配置类
 * 使用@Configuration 声明当前类是一个配置类
 * 使用@ComponentScan,自动扫描包下所有的@Service,@Component,@Repository,@Controller,并注册为bean
 *
 * @author Future
 */
@Configuration
@ComponentScan("com.springboot.actualcombat.springbase.ioc")
public class DiConfig {

}

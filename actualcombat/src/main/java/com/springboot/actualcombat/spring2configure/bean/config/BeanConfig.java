package com.springboot.actualcombat.spring2configure.bean.config;

import com.springboot.actualcombat.spring2configure.bean.service.BeanWayService;
import com.springboot.actualcombat.spring2configure.bean.service.Jsr250WayService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Future
 */
@Configuration
@ComponentScan("com.springboot.actualcombat.spring2configure.bean")
public class BeanConfig {

    /**
     * initMethod和destroyMethod指定BeanWayService中的initMethod()和destroyMethon()构造函数执行完之后执行，Bean销毁前执行
     * @return
     */
    @Bean(initMethod = "initMethod",destroyMethod = "destroyMethon")
    BeanWayService beanWayService(){
        return new BeanWayService();
    }

    @Bean
    Jsr250WayService jsr250WayService(){
        return new Jsr250WayService();
    }

}

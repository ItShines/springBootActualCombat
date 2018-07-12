package com.springboot.actualcombat.spring2configure.bean.controller;

import com.springboot.actualcombat.spring2configure.bean.config.BeanConfig;
import com.springboot.actualcombat.spring2configure.bean.service.BeanWayService;
import com.springboot.actualcombat.spring2configure.bean.service.Jsr250WayService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Future
 */
public class BeanMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
        BeanWayService beanWayService = context.getBean(BeanWayService.class);
        Jsr250WayService jsr250WayService = context.getBean(Jsr250WayService.class);
        context.close();
    }
}

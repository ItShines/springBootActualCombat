package com.springboot.actualcombat.spring2configure.applicationevent.controller;

import com.springboot.actualcombat.spring2configure.applicationevent.config.EventConfig;
import com.springboot.actualcombat.spring2configure.applicationevent.publisher.EventPulisher;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 5.运行
 *
 * @author Future
 */
public class EventMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(EventConfig.class);
        EventPulisher eventPulisher = context.getBean(EventPulisher.class);
        eventPulisher.pulish("hello application event ");
        context.close();
    }
}

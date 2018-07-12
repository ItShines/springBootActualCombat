package com.springboot.actualcombat.spring3advancedtopic.springaware.controller;

import com.springboot.actualcombat.spring3advancedtopic.springaware.config.AwareConfig;
import com.springboot.actualcombat.spring3advancedtopic.springaware.service.AwareService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Future
 */
public class AwareMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AwareConfig.class);
        AwareService awareService = context.getBean(AwareService.class);
        awareService.outpResult();
        context.close();
    }
}

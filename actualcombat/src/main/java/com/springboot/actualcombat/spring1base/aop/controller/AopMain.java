package com.springboot.actualcombat.spring1base.aop.controller;

import com.springboot.actualcombat.spring1base.aop.config.AopConfig;
import com.springboot.actualcombat.spring1base.aop.service.AnnotationService;
import com.springboot.actualcombat.spring1base.aop.service.MethodService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Future
 */
public class AopMain {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AopConfig.class);
        AnnotationService annotationService = context.getBean(AnnotationService.class);
        MethodService methodService = context.getBean(MethodService.class);
        annotationService.add();
        methodService.add();
        context.close();
    }
}

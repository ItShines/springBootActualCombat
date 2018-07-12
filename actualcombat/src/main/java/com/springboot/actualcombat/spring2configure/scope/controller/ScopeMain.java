package com.springboot.actualcombat.spring2configure.scope.controller;

import com.springboot.actualcombat.spring2configure.scope.config.ScopeConfig;
import com.springboot.actualcombat.spring2configure.scope.service.PrototypeService;
import com.springboot.actualcombat.spring2configure.scope.service.SingletonService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Future
 */
public class ScopeMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ScopeConfig.class);
        SingletonService singletonService1 = context.getBean(SingletonService.class);
        SingletonService singletonService2 = context.getBean(SingletonService.class);
        PrototypeService prototypeService1 = context.getBean(PrototypeService.class);
        PrototypeService prototypeService2 = context.getBean(PrototypeService.class);
        System.out.println("singletonService1 与 singletonService2 是否相等：" + singletonService1.equals(singletonService2));
        System.out.println("prototypeService1 与 prototypeService2 是否相等：" + prototypeService1.equals(prototypeService2));
        context.close();
    }
}

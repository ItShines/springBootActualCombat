package com.springboot.actualcombat.springbase.ioc.controller;

import com.springboot.actualcombat.springbase.ioc.config.DiConfig;
import com.springboot.actualcombat.springbase.ioc.service.UseFunctionService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 运行
 * 使用AnnotationConfigApplicationContext作为spring的容器,接收输入一个配置类做为参数;
 * 使用getBean()方法 获取声明配置的UseFunctionService的bean
 *
 * @author Future
 */
public class IocMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DiConfig.class);
        UseFunctionService useFunctionService = context.getBean(UseFunctionService.class);
        System.out.println(useFunctionService.sayHello("word"));
        context.close();
    }
}

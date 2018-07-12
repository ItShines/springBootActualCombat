package com.springboot.actualcombat.spring1base.javaconfigure.controller;

import com.springboot.actualcombat.spring1base.javaconfigure.config.JavaConfig;
import com.springboot.actualcombat.spring1base.javaconfigure.service.UseFunctionService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 运行
 * 使用AnnotationConfigApplicationContext作为spring的容器,接收输入一个配置类做为参数;
 * 使用getBean()方法 获取声明配置的UseFunctionService的bean
 *
 * @author Future
 */
public class JavaMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
        UseFunctionService useFunctionService = context.getBean(UseFunctionService.class);
        System.out.println(useFunctionService.sayHello("java config"));
        context.close();
    }
}

package com.springboot.actualcombat.spring3advancedtopic.condition.controller;

import com.springboot.actualcombat.spring3advancedtopic.condition.config.ConditionConfig;
import com.springboot.actualcombat.spring3advancedtopic.condition.service.ListService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Future
 */
public class ConditionMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext configApplicationContext = new AnnotationConfigApplicationContext(ConditionConfig.class);
        ListService listService = configApplicationContext.getBean(ListService.class);
        System.out.println(configApplicationContext.getEnvironment().getProperty("os.name") +
                "系统下的列表命令为："+listService.showListCmd());
    }
}

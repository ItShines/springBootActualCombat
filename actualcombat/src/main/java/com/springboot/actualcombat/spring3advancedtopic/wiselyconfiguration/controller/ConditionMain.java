package com.springboot.actualcombat.spring3advancedtopic.wiselyconfiguration.controller;

import com.springboot.actualcombat.spring3advancedtopic.wiselyconfiguration.config.WiselyConditionConfig;
import com.springboot.actualcombat.spring3advancedtopic.wiselyconfiguration.service.ListService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Future
 */
public class ConditionMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext configApplicationContext = new AnnotationConfigApplicationContext(WiselyConditionConfig.class);
        ListService listService = configApplicationContext.getBean(ListService.class);
        System.out.println(configApplicationContext.getEnvironment().getProperty("os.name") +
                "系统下的列表命令为：" + listService.showListCmd());
    }
}

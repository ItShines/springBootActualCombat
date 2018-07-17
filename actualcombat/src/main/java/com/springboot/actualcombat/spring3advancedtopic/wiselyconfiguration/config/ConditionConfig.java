package com.springboot.actualcombat.spring3advancedtopic.wiselyconfiguration.config;

import com.springboot.actualcombat.spring3advancedtopic.wiselyconfiguration.WiselyConfiguration;
import com.springboot.actualcombat.spring3advancedtopic.wiselyconfiguration.condition.MacosCondition;
import com.springboot.actualcombat.spring3advancedtopic.wiselyconfiguration.condition.WindowsCondition;
import com.springboot.actualcombat.spring3advancedtopic.wiselyconfiguration.service.ListService;
import com.springboot.actualcombat.spring3advancedtopic.wiselyconfiguration.service.MacosListService;
import com.springboot.actualcombat.spring3advancedtopic.wiselyconfiguration.service.WindowsListService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * 2.使用组合注解@WiselyConfiguration代替@Configuration 和@ComponentScan注解
 * @author Future
 */
@WiselyConfiguration("com.springboot.actualcombat.spring3advancedtopic.condition")
public class ConditionConfig {
    /**
     * 通过使用@Conditional注解，符合windows条件则实例化WindowsListService;
     * @return
     */
    @Bean
    @Conditional(WindowsCondition.class)
    public ListService windowsListService(){
        return new WindowsListService();
    }

    @Bean
    @Conditional(MacosCondition.class)
    public ListService macosListService(){
        return new MacosListService();
    }
}

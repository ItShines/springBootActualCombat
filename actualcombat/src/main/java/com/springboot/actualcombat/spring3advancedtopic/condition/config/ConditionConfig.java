package com.springboot.actualcombat.spring3advancedtopic.condition.config;

import com.springboot.actualcombat.spring3advancedtopic.condition.condition.MacosCondition;
import com.springboot.actualcombat.spring3advancedtopic.condition.condition.WindowsCondition;
import com.springboot.actualcombat.spring3advancedtopic.condition.service.ListService;
import com.springboot.actualcombat.spring3advancedtopic.condition.service.MacosListService;
import com.springboot.actualcombat.spring3advancedtopic.condition.service.WindowsListService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * @author Future
 */
@Configuration
@ComponentScan("com.springboot.actualcombat.spring3advancedtopic.condition")
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

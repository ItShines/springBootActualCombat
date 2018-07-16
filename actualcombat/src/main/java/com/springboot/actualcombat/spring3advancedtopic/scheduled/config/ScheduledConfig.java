package com.springboot.actualcombat.spring3advancedtopic.scheduled.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 通过@EnableScheduling注解开启对计划任务的支持
 * @author Future
 */
@Configuration
@ComponentScan("com.springboot.actualcombat.spring3advancedtopic.scheduled")
@EnableScheduling
public class ScheduledConfig {

}

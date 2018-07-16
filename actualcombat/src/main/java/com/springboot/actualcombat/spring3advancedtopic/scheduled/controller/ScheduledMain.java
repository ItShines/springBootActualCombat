package com.springboot.actualcombat.spring3advancedtopic.scheduled.controller;

import com.springboot.actualcombat.spring3advancedtopic.scheduled.config.ScheduledConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Future
 */
public class ScheduledMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext configApplicationContext = new AnnotationConfigApplicationContext(ScheduledConfig.class);

    }
}

package com.springboot.actualcombat.spring3advancedtopic.wiselyconfiguration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.lang.annotation.*;

/**
 * 1.组合注解
 * 组合@Configuration 和@ComponentScan注解
 * @author Future
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Configuration
@ComponentScan
public @interface WiselyConfiguration {
    /**
     * 覆盖value
     * @return
     */
    String[] value () default {

    };
}

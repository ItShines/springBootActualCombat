package com.springboot.actualcombat.springconfigure.el.controller;

import com.springboot.actualcombat.springconfigure.el.config.ElConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Future
 */
public class ElMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ElConfig.class);
        ElConfig elConfig = context.getBean(ElConfig.class);
        elConfig.outputResource();
        context.close();
    }
}

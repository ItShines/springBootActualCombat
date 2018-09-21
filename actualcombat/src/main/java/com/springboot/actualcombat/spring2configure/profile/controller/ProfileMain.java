package com.springboot.actualcombat.spring2configure.profile.controller;

import com.springboot.actualcombat.spring2configure.profile.bean.ProfileBean;
import com.springboot.actualcombat.spring2configure.profile.config.ProfileConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 3.运行
 *
 * @author Future
 */
public class ProfileMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        //设定活动的Profile值为prod
        context.getEnvironment().setActiveProfiles("prod");
        //注册Bean的配置类        否则报bean未定义
        context.register(ProfileConfig.class);
        //刷新容器
        context.refresh();
        ProfileBean profileBean = context.getBean(ProfileBean.class);
        System.out.println(profileBean.getContent());
        context.close();
    }
}

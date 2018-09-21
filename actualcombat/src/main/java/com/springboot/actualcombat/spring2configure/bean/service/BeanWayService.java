package com.springboot.actualcombat.spring2configure.bean.service;

import org.springframework.stereotype.Service;

/**
 * @author Future
 */
@Service
public class BeanWayService {
    public void initMethod() {
        System.out.println("@Bean-init-method");
    }

    public BeanWayService() {
        super();
        System.out.println("初始化构造函数-BeanWayService");
    }

    public void destroyMethon() {
        System.out.println("@Bean-destroy-method");
    }
}

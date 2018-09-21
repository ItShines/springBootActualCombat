package com.springboot.actualcombat.spring2configure.bean.service;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author Future
 */
@Service
public class Jsr250WayService {
    /**
     * @PostConstruct 构造函数执行完之后执行
     */
    @PostConstruct
    public void initMethod() {
        System.out.println("Jsr250-init-method");
    }

    public Jsr250WayService() {
        super();
        System.out.println("初始化构造函数-Jsr250WayService");
    }

    /**
     * @PreDestroy Bean销毁前执行
     */
    @PreDestroy
    public void destroyMethod() {
        System.out.println("Jsr250-destroy-method");
    }
}

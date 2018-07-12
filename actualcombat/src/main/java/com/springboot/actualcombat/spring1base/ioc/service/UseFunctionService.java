package com.springboot.actualcombat.spring1base.ioc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 使用功能类
 * 使用@Service注解声明当前FunctionService是spring管理的一个bean
 *
 * @author Future
 */
@Service
public class UseFunctionService {

    /**
     * 使用@Autowired注解把FunctionService的实体注入到UseFunctionService，
     * 使UseFunctionService具有FunctionService同样的功能
     * 此处使用JSR-330的@Inject注解和JSR-250的@Resource注解等效
     */
    @Autowired
    private FunctionService functionService;

    public String sayHello(String word) {
        return functionService.sayHello(word);
    }
}

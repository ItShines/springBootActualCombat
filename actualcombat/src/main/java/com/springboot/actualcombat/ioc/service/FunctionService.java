package com.springboot.actualcombat.ioc.service;

import org.springframework.stereotype.Service;

/**
 * 功能类
 * 使用@Service注解声明当前FunctionService是spring管理的一个bean
 *
 * @author Future
 */
@Service
public class FunctionService {

    public String sayHello(String word) {
        return "Hello   " + word + "!";
    }
}

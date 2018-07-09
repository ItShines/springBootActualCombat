package com.springboot.actualcombat.javaconfigure.service;

/**
 * 功能类
 * 不使用@Service注解声明
 *
 * @author Future
 */
public class FunctionService {

    public String sayHello(String word) {
        return "Hello   " + word + "!";
    }
}

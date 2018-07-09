package com.springboot.actualcombat.javaconfigure.service;

/**
 * 使用功能类
 * 不使用@Service注解声明
 *
 * @author Future
 */
public class UseFunctionService {

    /**
     * 不使用注入
     */
    private FunctionService functionService;

    public void setFunctionService(FunctionService functionService) {
        this.functionService = functionService;
    }

    public String sayHello(String word) {
        return functionService.sayHello(word);
    }
}

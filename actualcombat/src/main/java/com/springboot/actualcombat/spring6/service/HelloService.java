package com.springboot.actualcombat.spring6.service;

/**
 * 3.判断依据类
 * @author Future
 */

public class HelloService {

    private String msg;

    private String sayHello(){
        return "hello " + msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}

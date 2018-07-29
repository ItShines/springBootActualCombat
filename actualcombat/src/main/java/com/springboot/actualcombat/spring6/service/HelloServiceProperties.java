package com.springboot.actualcombat.spring6.service;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Future
 */
@ConfigurationProperties(prefix = "hello")
public class HelloServiceProperties {

    private static final String MSG ="world";

    private String msg = MSG;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}

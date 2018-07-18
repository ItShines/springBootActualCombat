package com.springboot.actualcombat.spring3advancedtopic.junit.bean;

/**
 * 2.配置业务Bean
 *
 * @author Future
 */
public class TestBean {

    private String context;

    public TestBean(String context) {
        super();
        this.context = context;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }
}

package com.springboot.actualcombat.spring2configure.profile.bean;

/**
 * 1.定义profile内容
 *
 * @author Future
 */
public class ProfileBean {

    private String content;

    public ProfileBean(String content) {
        super();
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

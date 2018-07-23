package com.springboot.actualcombat.spring6.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 通过@ConfigurationProperties加载applicatioin.preperties文件内的配置内容,通过prefix属性指定
 * properties的配置的前缀
 *
 * @author Future
 */
@Component
@ConfigurationProperties(prefix = "auth")
public class AuthSetting {

    private String name;

    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

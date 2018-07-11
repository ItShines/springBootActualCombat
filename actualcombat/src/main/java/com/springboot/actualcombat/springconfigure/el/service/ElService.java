package com.springboot.actualcombat.springconfigure.el.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author Future
 */
@Service
public class ElService {

    /**
     * 此处为注入普通字符串
     */
    @Value("其他类的属性")
    private String another;

    public String getAnother() {
        return another;
    }

    public void setAnother(String another) {
        this.another = another;
    }
}

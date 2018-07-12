package com.springboot.actualcombat.spring2configure.applicationevent.bean;

import org.springframework.context.ApplicationEvent;

/**
 * 1.自定义事件
 * @author Future
 */
public class EventBean extends ApplicationEvent {
    private static final long serialVersionUID = 1L;
    private String message;

    public EventBean(Object source,String message) {
        super(source);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

package com.springboot.actualcombat.spring2configure.applicationevent.publisher;

import com.springboot.actualcombat.spring2configure.applicationevent.bean.EventBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * 3.事件发布类
 *
 * @author Future
 */
@Component
public class EventPulisher {

    /**
     * 注入ApplicationContext用来发布事件
     */
    @Autowired
    private ApplicationContext applicationContext;

    public void pulish(String message) {
        //使用ApplicationContext的publishEvent发布事件
        applicationContext.publishEvent(new EventBean(this, message));
    }

}

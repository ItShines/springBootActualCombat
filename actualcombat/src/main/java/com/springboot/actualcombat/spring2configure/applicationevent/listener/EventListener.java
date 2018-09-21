package com.springboot.actualcombat.spring2configure.applicationevent.listener;

import com.springboot.actualcombat.spring2configure.applicationevent.bean.EventBean;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 2.事件监听器
 * 实现ApplicationListener<EventBean>接口，并制定监听的事件类型
 *
 * @author Future
 */
@Component
public class EventListener implements ApplicationListener<EventBean> {

    /**
     * 使用onApplicationEvent对消息进行接受处理
     *
     * @param eventBean
     */
    @Override
    public void onApplicationEvent(EventBean eventBean) {
        String message = eventBean.getMessage();
        System.out.println("我(bean - eventListener)接收到了bean-eventBean发布的消息：" + message);
    }
}

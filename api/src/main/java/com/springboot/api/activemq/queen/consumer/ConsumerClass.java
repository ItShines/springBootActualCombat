package com.springboot.api.activemq.queen.consumer;

import com.springboot.api.activemq.util.ActiveMqManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @author zhangsanfeng
 */
@Component
public class ConsumerClass {
    @Autowired
    ActiveMqManager activeMqManager;

    @JmsListener(destination = "queueFirstTest")
    public void getQueue(String message){
        System.out.println("收到的 message 是：" + message);
    }
}

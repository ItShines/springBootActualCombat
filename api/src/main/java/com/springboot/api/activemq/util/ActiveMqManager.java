package com.springboot.api.activemq.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Destination;

/**
 * @author zhangsanfeng
 */
@Component
public class ActiveMqManager {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    /**
     *
     * @param destination
     * @param data
     */
    public void send(Destination destination, String data){
        jmsMessagingTemplate.convertAndSend(destination,data);
    }
}

package com.springboot.ecs.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * @author wb-ryd460712
 */
@Service
@EnableScheduling
public class QueenClass {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Scheduled(fixedDelay = 3000)
    public void sendMessage(){
        String destination = "Queen";
        String message = "每隔3秒发一次！！！当前时间戳为：" + System.currentTimeMillis();
        jmsMessagingTemplate.convertAndSend(destination, message);
    }
}

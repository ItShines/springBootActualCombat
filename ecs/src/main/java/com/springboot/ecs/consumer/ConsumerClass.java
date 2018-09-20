package com.springboot.ecs.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

/**
 * @author wb-ryd460712
 */
@Component
public class ConsumerClass {

    private Logger logger = LoggerFactory.getLogger(Component.class);

    @JmsListener(destination = "Queen")
    public void getMessage(Message message) throws JMSException {
        TextMessage textMessage = (TextMessage) message;
        logger.info("consumer收到的消息为：" + textMessage.getText());
        System.out.println("consumer收到的消息为：" + textMessage.getText());
    }
}

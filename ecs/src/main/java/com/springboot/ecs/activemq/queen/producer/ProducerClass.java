package com.springboot.ecs.activemq.queen.producer;

import com.springboot.ecs.activemq.util.ActiveMqManager;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jms.Destination;

/**
 * @author zhangsanfeng
 */
@Component
public class ProducerClass {

    @Autowired
    ActiveMqManager activeMqManager;

    /**
     * @param data
     */
    public void sendQueue(String data) {
        Destination destination = new ActiveMQQueue("queueFirstTest");
        activeMqManager.send(destination, data);
    }

}

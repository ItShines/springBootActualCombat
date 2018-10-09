package com.springboot.ecs.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wb-ryd460712
 */
@Service
public class ProducerService {

    @Autowired
    private ActiveMqSendUtil activeMqSendUtil;

    public void sendMessage(String message) {
        activeMqSendUtil.send("queueProducerTest", message);
    }
}

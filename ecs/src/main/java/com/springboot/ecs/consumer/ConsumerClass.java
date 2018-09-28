package com.springboot.ecs.consumer;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.*;

/**
 * @author wb-ryd460712
 */
@Component
public class ConsumerClass {

    private Logger logger = LoggerFactory.getLogger(Component.class);

//    @JmsListener(destination = "queueProducerTest")
    public void getMessage(Message message) throws JMSException {
        TextMessage textMessage = (TextMessage) message;
        logger.info("consumer收到的消息为：" + textMessage.getText());
    }

    public void getMessage() {
        try {
            //第一步：建立ConnectionFactory工厂对象，需要填入用户名、密码、以及要连接的地址，均使用默认即可，默认端口为"tcp://localhost:61616"
            ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnectionFactory.DEFAULT_USER,
                    ActiveMQConnectionFactory.DEFAULT_PASSWORD,
                    "tcp://39.105.89.202:61616");
            //第二步：通过ConnectionFactory工厂对象我们创建一个Connection连接，并且调用Connection的start方法开启连接，Connection默认是关闭的。
            Connection connection = connectionFactory.createConnection();
            connection.start();
            //第三步：通过Connection对象创建Session会话（上下文环境对象），用于接收消息，参数配置1为是否启用是事务，参数配置2为签收模式，一般我们设置自动签收。
            Session session = connection.createSession(Boolean.TRUE, Session.CLIENT_ACKNOWLEDGE); //Boolean.TRUE：消息持久化到activemq_msgs表，Boolean.FALSE：消息处理完成把该条记录删除
            //第四步：通过Session创建Destination对象，指的是一个客户端用来指定生产消息目标和消费消息来源的对象，在PTP模式中，Destination被称作Queue即队列；在Pub/Sub模式，Destination被称作Topic即主题。在程序中可以使用多个Queue和Topic。
            Destination destination = session.createQueue("queueProducerTest");
            //第五步：通过Session创建MessageConsumer
            MessageConsumer consumer = session.createConsumer(destination);
            while (true) {
                TextMessage msg = (TextMessage) consumer.receive();
                if (msg == null) {
                    break;
                }
                msg.acknowledge();
                System.out.println("收到的内容：" + msg.getText());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

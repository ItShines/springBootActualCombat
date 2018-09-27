package com.springboot.ecs.producer;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.jms.*;

/**
 * @author zhangsanfeng
 */
@Component
public class ActiveMqSendUtil{

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    /**
     * @param destinationName
     * @param data
     */
    public void send(String destinationName, String data) {
//        jmsMessagingTemplate.convertAndSend(destination, data);
        try {
            //第一步：建立ConnectionFactory工厂对象，需要填入用户名、密码，以及要连接的地址，均使用默认即可，默认端口为："tcp://localhost:61616"
            ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnectionFactory.DEFAULT_USER,
                    ActiveMQConnectionFactory.DEFAULT_PASSWORD,
                    "tcp://39.105.89.202:61616");
            // 第二步：通过ConnectionFactory工厂对象，我们创建一个Connection连接，并且采用Connection的start方法开启连接，Connection默认是关闭的
            Connection connection = connectionFactory.createConnection();
            connection.start();
            // 第三步：通过Connection对象创建Session会话，用于接收消息，参数配置1是事务，参数配置2是签收模式，一般我们设置自动签收
            Session session = connection.createSession(Boolean.TRUE, Session.CLIENT_ACKNOWLEDGE);
            /**
             * Session session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);
             * 使用事务的方式进行消息的发送
             * Session session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
             * 使用Client端签收的方式
             * Session session = connection.createSession(Boolean.TRUE, Session.CLIENT_ACKNOWLEDGE);
             * 第四步：通过session创建Destination对象，指的是一个客户端用来指定生产消息目标和消费消息来源的对象，
             * 在PTP模板中Destination被称作Topic主题。在程序中可以使用多个Queue和Topic
             * Destination destination = session.createQueue("HelloWorld");
             * 第五步：通过session对象创建消息的发送和接收对象(生产者和消费者)MessageProducer、MessageConsumer
             */
            Destination destination = session.createQueue(destinationName);
            MessageProducer messageProducer = session.createProducer(destination);
            // 第六步：使用MessageProducer的setSelveryMode方法为其设置持久化特性和非持久化特性(DeliveryMode)//
            messageProducer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
            // 第七步：最后我们使用JMS规范的TextMessage形式创建数据(通过Session对象)，并用MessageProducer的send方法发送数据，
            // 同理客户端使用receive方法进行接收数据。最后不要忘记关机Connection连接
            TextMessage textMessage = session.createTextMessage();
            textMessage.setText(data);
            // 	第一个参数：目的地
            // 	第二个参数：消息
            //  第三个参数：是否持久化
            //  第四个参数：优先级
            //  第五个参数：消息在jms上面的存放时间
            messageProducer.send(destination, textMessage, DeliveryMode.PERSISTENT, 0, 1000 * 60);
            System.out.println(textMessage);
            // 使用事务提交
            session.commit();
            if (connection != null) {
                connection.close();
            }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
}

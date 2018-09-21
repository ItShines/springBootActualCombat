package com.springboot.api.activemq.queen;

import com.springboot.api.activemq.queen.producer.ProducerClass;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author zhangsanfeng
 */
public class TestClass {

    public static void main(String[] args) {

        ProducerClass producerClass = new ProducerClass();

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 10,
                5, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());


        threadPoolExecutor.execute(new Runnable() {
            @Override
            public void run() {
                for (int i = 100; i < 200; i++) {
                    producerClass.sendQueue("第" + i + "次，发送信息，信息内容为： 张三丰您好！");
                }
            }
        });

        threadPoolExecutor.execute(new Runnable() {
            @Override
            public void run() {
                for (int i = 200; i < 300; i++) {
                    producerClass.sendQueue("第" + i + "次，发送信息，信息内容为： 张三丰您好！");
                }
            }
        });

        threadPoolExecutor.execute(new Runnable() {
            @Override
            public void run() {
                for (int i = 300; i < 400; i++) {
                    producerClass.sendQueue("第" + i + "次，发送信息，信息内容为： 张三丰您好！");
                }
            }
        });

        threadPoolExecutor.execute(new Runnable() {
            @Override
            public void run() {
                for (int i = 400; i < 500; i++) {
                    producerClass.sendQueue("第" + i + "次，发送信息，信息内容为： 张三丰您好！");
                }
            }
        });

        threadPoolExecutor.execute(new Runnable() {
            @Override
            public void run() {
                for (int i = 500; i < 600; i++) {
                    producerClass.sendQueue("第" + i + "次，发送信息，信息内容为： 张三丰您好！");
                }
            }
        });
    }
}

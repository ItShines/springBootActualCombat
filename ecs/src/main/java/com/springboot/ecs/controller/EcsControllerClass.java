package com.springboot.ecs.controller;

import com.springboot.ecs.producer.ProducerService;
import com.springboot.ecs.util.MagicValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


/**
 * @author zhangsanfeng
 */
@EnableScheduling
@Controller
public class EcsControllerClass {

    @Autowired
    private ProducerService producerService;

    @Scheduled(fixedDelay = 3000)
    public void thread() {
        ThreadPoolExecutor threadPools = new ThreadPoolExecutor(5, 10, 4,
                TimeUnit.SECONDS, new SynchronousQueue<Runnable>());
        System.out.println(MagicValue.five);
        System.out.println(MagicValue.three);
        System.out.println(MagicValue.intTwo);
        for (int i = 0; i < MagicValue.intFive; i++) {
            String message = "每隔3秒发5次！！！当前第" + (i + 1) + "次发送,时间戳为：" + System.currentTimeMillis();
            threadPools.execute(() -> producerService.sendMessage(message));
            System.out.println(message);
        }
    }

}

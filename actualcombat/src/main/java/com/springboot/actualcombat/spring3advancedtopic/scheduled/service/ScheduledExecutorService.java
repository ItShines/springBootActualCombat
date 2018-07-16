package com.springboot.actualcombat.spring3advancedtopic.scheduled.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Spring通过@Scheudled支持多种类型的计划任务，包含cron，fixDelay，fixRate等
 * @author Future
 */
@Service
public class ScheduledExecutorService {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH ：mm：ss");

    /**
     * 通过@Scheduled注解声明该方法是一个定时任务，使用fixedRate属性每隔固定时间执行一次
     */
    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime(){
        System.out.println("每隔五秒执行一次 " +dateFormat.format(new Date()));
    }

    /**
     * 通过使用cron属性可按照指定时间执行，cron是Linux和unix系统下的定时任务
     */
    @Scheduled(cron = "0 28 11 ? * **")
    public void fixTimeExecutor(){
        System.out.println("在指定时间" + dateFormat.format(new Date()) + "执行");
    }
}

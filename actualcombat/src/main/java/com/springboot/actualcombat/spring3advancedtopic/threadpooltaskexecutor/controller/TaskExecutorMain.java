package com.springboot.actualcombat.spring3advancedtopic.threadpooltaskexecutor.controller;

import com.springboot.actualcombat.spring3advancedtopic.threadpooltaskexecutor.config.TaskExecutorConfig;
import com.springboot.actualcombat.spring3advancedtopic.threadpooltaskexecutor.service.AsyncTaskExecutorService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 3.运行
 * @author Future
 */
public class TaskExecutorMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext configApplicationContext = new AnnotationConfigApplicationContext(TaskExecutorConfig.class);
        AsyncTaskExecutorService taskExecutorService = configApplicationContext.getBean(AsyncTaskExecutorService.class);
        for (int i = 0; i < 10; i++) {
            taskExecutorService.executorAsyncTask(i);
            taskExecutorService.executorAsyncTaskPlus(i);
        }
        configApplicationContext.close();
    }
}

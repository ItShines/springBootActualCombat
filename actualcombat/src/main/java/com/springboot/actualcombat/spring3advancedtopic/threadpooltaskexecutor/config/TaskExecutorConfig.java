package com.springboot.actualcombat.spring3advancedtopic.threadpooltaskexecutor.config;


import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 * 1.配置类
 * 使用@EnableAsync 开启异步任务支持
 * 配置类实现AsyncConfigurer接口，并重写getAsyncExecutor（），并返回一个ThreadPoolTaskExecutor
 * 这样就可以得到一个基于线程池的TaskExecutor
 *
 * @author Future
 */
@Configuration
@ComponentScan("com.springboot.actualcombat.spring3advancedtopic.threadpooltaskexecutor")
@EnableAsync
public class TaskExecutorConfig implements AsyncConfigurer {

    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setCorePoolSize(5);
        threadPoolTaskExecutor.setMaxPoolSize(10);
        threadPoolTaskExecutor.setQueueCapacity(25);
        threadPoolTaskExecutor.initialize();
        return threadPoolTaskExecutor;
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return null;
    }
}

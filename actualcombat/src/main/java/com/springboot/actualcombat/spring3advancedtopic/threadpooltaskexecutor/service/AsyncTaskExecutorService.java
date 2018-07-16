package com.springboot.actualcombat.spring3advancedtopic.threadpooltaskexecutor.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author Future
 */
@Service
public class AsyncTaskExecutorService {
    /**
     * 2。实现类
     * 通过@Async注解表明这个方法是个异步方法，如果注解在类级别，表明该类下的所有方法
     *  都是异步方法，而这里的方法自动被注入使用ThreadPoolTaskExecutor作为TaskExecutor
     * @param i
     */
    @Async
    public void executorAsyncTask(Integer i){
        System.out.println("执行异步任务："+ i);
    }

    @Async
    public void executorAsyncTaskPlus(Integer i){
        System.out.println("执行异步任务+1"+i);
    }

}

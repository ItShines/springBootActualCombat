package com.springboot.actualcombat.spring3advancedtopic.scheduled.config;

import com.springboot.actualcombat.spring3advancedtopic.scheduled.service.ScheduledExecutorService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

/**
 * 通过@EnableScheduling注解开启对计划任务的支持
 * @author Future
 */
@Configuration
@ComponentScan("com.springboot.actualcombat.spring3advancedtopic.scheduled")
@EnableScheduling
public class ScheduledConfig {
    /**
     *  Spring的定时任务调度器会尝试获取一个注册过的task scheduler来做任务调度，它会尝试通过BeanFactory.getBean的方法来
     *      获取一个注册过的scheduler bean，获取的步骤如下：
     *          1.尝试从配置中找到一个TaskScheduler Bean
     *          2.寻找ScheduledExecutorService Bean
     *          3.使用默认的scheduler
     *      前两步，如果找不到的话，就会以debug的方式抛出异常，分别是：
     *          logger.debug(“Could not find default TaskScheduler bean”, ex);
     *              org.springframework.beans.factory.NoSuchBeanDefinitionException: No qualifying bean of type 'org.springframework.scheduling.TaskScheduler' available
     *          logger.debug(“Could not find default ScheduledExecutorService bean”, ex);
     *     所以，日志中打印出来的两个异常，根本不是什么错误信息，也不会影响定时器的使用，只不过是spring的自己打印的一些
     *          信息罢了，不过没搞明白，为什么非要用异常的方式打出来，估计是为了看这清晰点吧。
     *          也或者，这里面有一些重要的信息需要提示开发者。具体是什么原因，只能有机会进一步再去了解了。
     *    解决办法：
     *    既然提示容器中没有，在容器中添加这个Bean即可。配置类中可添加如下代码：
     */

    /**
     * Spring容器提示没有TaskScheduler
     * 注入TaskScheduler
     *
     * @return
     */
    @Bean
    public TaskScheduler scheduledExecutorService() {
        ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
        scheduler.setPoolSize(10);
        scheduler.setThreadNamePrefix("scheduledExecutor-");
        return scheduler;
    }

    /**
     * 注入ScheduledExecutorService实现类
     *
     * @return
     */
    @Bean
    public ScheduledExecutorService scheduledExecutor() {
        return new ScheduledExecutorService();
    }


}

package com.springboot.actualcombat.spring3advancedtopic.enable.directimport;

import com.springboot.actualcombat.spring3advancedtopic.scheduled.config.ScheduledConfig;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.SchedulingConfiguration;

import java.lang.annotation.*;

/**
 * 1.直接导入配置类
 * 直接导入配置类SchedulingConfiguration,这个类注解了@Configuration，且注册了一个
 * ScheduledAnnotationBeanPostProcessor的Bean
 *
 * @author Future
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(SchedulingConfiguration.class)
@Documented
public @interface EnableScheduling {

}

package com.springboot.actualcombat.spring3advancedtopic.enable.condition;

import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.Import;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.AsyncConfigurationSelector;

import java.lang.annotation.*;

/**
 * 2.依据选择配置类
 * AsyncConfigurationSelector通过条件来选择需要导入的配置类，AsyncConfigurationSelector的根
 * 接口为ImportSelector,这个接口需要重写selectImports方法，在方法内部进行实现条件判断。
 * 在此，若adviceMode为PROXY,则返回ProxyAsyncConfiguration这个配置类;
 * 若adviceMode为ASPECTJ,则返回 AspectJAsyncConfiguration配置类
 * 源码 AsyncConfigurationSelector类中
 *
 * @author Future
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(AsyncConfigurationSelector.class)
@Documented
public @interface EnableAsync {
    Class<? extends Annotation> annotation() default Annotation.class;

    boolean proxyTargetClass() default false;

    AdviceMode mode() default AdviceMode.PROXY;

    int order() default Ordered.LOWEST_PRECEDENCE;
}

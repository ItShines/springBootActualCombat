package com.springboot.actualcombat.spring3advancedtopic.enable.dynamic;


import java.lang.annotation.*;

/**
 * AspectJAutoProxyRegistrar实现ImportBeanDefinitionRegistrar接口，
 * ImportBeanDefinitionRegistrar接口的作用是在运行的时候自动创建Bean到已有的配置,通过重写方法
 * registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry)
 * 其中AnnotationMetadata参数用来获取当前配置类上的注解;
 * BeanDefinitionRegistry参数用来注册Bean
 * 源码 AspectJAutoProxyRegistrar类中
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
//@Import({AspectJAutoProxyRegistrar.class})//内部类
public @interface EnableAspectJAutoProxy {
    boolean proxyTargetClass() default false;

    boolean exposeProxy() default false;
}


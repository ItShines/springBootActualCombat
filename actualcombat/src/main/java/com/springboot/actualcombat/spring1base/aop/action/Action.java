package com.springboot.actualcombat.spring1base.aop.action;

import java.lang.annotation.*;

/**
 * 注解的功能来自用注解的地方，因为注解本身没有功能，元数据即解释数据的数据，即配置
 *
 * @author Future
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Action {

    String name();
}

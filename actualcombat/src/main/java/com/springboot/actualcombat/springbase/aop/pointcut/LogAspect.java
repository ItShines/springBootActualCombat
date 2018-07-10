package com.springboot.actualcombat.springbase.aop.pointcut;

import com.springboot.actualcombat.springbase.aop.action.Action;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 使用@Aspect 声明当前的类是一个切面
 * 使用@Component 让切面称为由spring管理的bean
 *
 * @author Future
 */
@Aspect
@Component
public class LogAspect {

    /**
     * 通过@PointCut注解声明切点
     */
    @Pointcut(value = "@annotation(com.springboot.actualcombat.springbase.aop.action.Action)")
    public void annotationPointCut() {
    }

    /**
     * 通过@After声明一个建言，并使用@PointCut定义的切点
     * 通过反射 method.getAnnotation(Action.class) 获取注解上的属性，然后做日记记录，下同
     *
     * @param joinPoint
     */
    @After("annotationPointCut()")
    public void after(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        Action annotation = method.getAnnotation(Action.class);
        System.out.println("注解式拦截：" + annotation.name());
    }

    /**
     * 通过@Before声明一个建言，此建言直接使用@拦截规则作为参数
     * <p>
     * 标识这个方法是个前置通知,  切点表达式表示执行任意类的任意方法.
     * 第一个 * 代表匹配任意修饰符及任意返回值,
     * 第二个 * 代表任意类的对象,
     * 第三个 * 代表任意方法
     *
     * @param joinPoint
     */
    @Before("execution(* com.springboot.actualcombat.springbase.aop.service.MethodService.*(..))")
    public void before(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        System.out.println("方法规则式拦截：" + method.getName());
    }
}

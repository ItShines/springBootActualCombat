package com.springboot.actualcombat.spring1base.aop.service;

import com.springboot.actualcombat.spring1base.aop.action.Action;
import org.springframework.stereotype.Service;

/**
 * @author Future
 */
@Service
public class AnnotationService {
    @Action(name = "注解式拦截的add操作")
    public void add() {

    }
}

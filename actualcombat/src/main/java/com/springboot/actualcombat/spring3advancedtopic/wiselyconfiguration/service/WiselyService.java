package com.springboot.actualcombat.spring3advancedtopic.wiselyconfiguration.service;

import org.springframework.stereotype.Service;

/**
 * @author Future
 */
@Service
public class WiselyService {
    public void outpResult() {
        System.out.println("从组合注解里面获取Bean");
    }
}

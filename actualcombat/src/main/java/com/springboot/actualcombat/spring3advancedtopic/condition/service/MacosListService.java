package com.springboot.actualcombat.spring3advancedtopic.condition.service;

/**
 * 3
 * @author Future
 */
public class MacosListService implements ListService {

    @Override
    public String showListCmd() {
        return "ll";
    }
}

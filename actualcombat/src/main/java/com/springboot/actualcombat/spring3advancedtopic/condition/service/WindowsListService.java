package com.springboot.actualcombat.spring3advancedtopic.condition.service;

/**
 * @author Future
 */
public class WindowsListService implements ListService {

    @Override
    public String showListCmd() {
        return "dir";
    }
}

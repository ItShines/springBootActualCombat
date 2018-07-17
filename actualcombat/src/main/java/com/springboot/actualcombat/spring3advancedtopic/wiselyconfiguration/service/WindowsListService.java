package com.springboot.actualcombat.spring3advancedtopic.wiselyconfiguration.service;

/**
 * @author Future
 */
public class WindowsListService implements ListService {

    @Override
    public String showListCmd() {
        return "dir";
    }
}

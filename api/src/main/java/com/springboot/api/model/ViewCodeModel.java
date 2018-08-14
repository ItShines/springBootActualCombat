package com.springboot.api.model;

import com.springboot.api.entity.ViewCode;

import java.util.List;

/**
 * @author Future
 */
public class ViewCodeModel {

    private List<ViewCode> data;

    private String pid ="s0001";

    public List<ViewCode> getData() {
        return data;
    }

    public void setData(List<ViewCode> data) {
        this.data = data;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }
}

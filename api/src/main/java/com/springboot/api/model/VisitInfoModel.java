package com.springboot.api.model;

import java.util.List;

/**
 * @author Future
 */
public class VisitInfoModel {
    private Object data;
    private String pid = "s00001";

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }
}

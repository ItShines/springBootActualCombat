package com.springboot.api.model;

/**
 * 返回查询住院登记信息结果封装实体对象
 *
 * @author Future
 */
public class SickVisitInfoModel {
    private Object data;
    private String pid = "s00003";

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

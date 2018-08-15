package com.springboot.api.model;

/**
 * @author Future
 */
public class MedReceiptRecordMasterModel {
     private Object Data;
     private String pid="s0004";

    public Object getData() {
        return Data;
    }

    public void setData(Object data) {
        Data = data;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }
}

package com.springboot.api.util;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;

/**
 * @author Future
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseResponseModel {

    private String code;

    private String message;

    private Date responseTime;

    private Object body;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(Date responseTime) {
        this.responseTime = responseTime;
    }

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }
}

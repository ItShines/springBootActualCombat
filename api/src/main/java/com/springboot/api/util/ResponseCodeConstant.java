package com.springboot.api.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author Future
 */
@Component
@PropertySource(value = "classpath:responseCode.properties")
public class ResponseCodeConstant {

    /**
     * 操作成功
     */
    @Value("${responseCode.success}")
    public String success;
    /**
     * 操作失败
     */
    @Value("${responseCode.error}")
    public String error;

}

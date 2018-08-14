package com.springboot.api.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author Future
 */
@Component
@PropertySource(value = "classpath:final-code.properties")
public class FinalCodeConstant {
    /**
     * 医疗机构编码
     */
    @Value("${finalCode.hospital_number}")
    public String hospital_number;

    /**
     * 操作成功
     */
    @Value("${finalCode.success}")
    public String success;
    /**
     * 操作失败
     */
    @Value("${finalCode.error}")
    public String error;
    /**
     * 客户端参数为null
     */
    @Value("${finalCode.clinic_param_null}")
    public String clinic_param_null;
    /**
     * 医疗机构编号为null
     */
    @Value("${finalCode.hospital_number_null}")
    public String hospital_number_null;
}

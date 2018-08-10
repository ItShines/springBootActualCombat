package com.springboot.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 门诊医保报销
 * @author Future
 */
@RestController
public class DrugInsurController {

    @RequestMapping(value = "test")
    public Map<String,String> test() {
        Map<String,String> hashMap = new HashMap();
        hashMap.put("test","测试项目成功");
        return hashMap;
    }
}

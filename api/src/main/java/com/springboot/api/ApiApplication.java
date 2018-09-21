package com.springboot.api;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * MapperScan扫描Dao层
 *
 * @author Future
 */
@SpringBootApplication
@MapperScan("com.springboot.api.dao")
@ServletComponentScan("com.springboot.api.servlet")
public class ApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class, args);
    }
}

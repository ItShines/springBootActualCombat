package com.springboot.actualcombat;

import com.springboot.actualcombat.spring6.bean.AuthSetting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Future
 * @SpringBootApplication组合注解主要组合了@SpringBootConfiguration、
 * @EnableAutoConfiguration、@componentScan若不用@SpringBootApplication 则在入口类加入相应注解就行。
 * @EnableAutoConfiguration让Spring Boot根据类路径的jar包依赖为当前项目进行自动配置
 * <p>
 * 关闭特定的配置使用@SpringBootApplication注解的exclude参数
 */
@RestController
@SpringBootApplication
public class ActualcombatApplication {

    @Value("${book.auth}")
    private String auto;
    @Value("${book.name}")
    private String name;

    /**
     * 通过Autowired直接注入此属性
     */
    @Autowired
    private AuthSetting authSetting;

    /**
     * 常规配置属性
     * @return
     */
//    @RequestMapping("/")
//    public String testProperties(){
//        return "Book name is "+ name + " and book auth is " + auto;
//    }

    /**
     * 类型安全的配置
     *
     * @return
     */
    @RequestMapping("/")
    public String testProperties() {
        return " book auth is " + authSetting.getName() + " and book auth age is " + authSetting.getAge();
    }

    public static void main(String[] args) {
        SpringApplication.run(ActualcombatApplication.class, args);
    }
}

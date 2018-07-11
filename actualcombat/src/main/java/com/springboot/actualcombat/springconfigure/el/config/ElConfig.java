package com.springboot.actualcombat.springconfigure.el.config;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;

import java.io.IOException;


/**
 * @author Future
 */
@Configuration
@ComponentScan("com.springboot.actualcombat.springconfigure.el")
@PropertySource(value = "classpath:com/springboot/actualcombat/springconfigure/el/el.properties", ignoreResourceNotFound = true)
public class ElConfig {

    /**
     * 注入普通字符串
     */
    @Value("LOVE ME")
    private String normal;

    /**
     * 注入操作系统属性
     */
    @Value("#{systemProperties['os.name']}")
    private String osName;

    /**
     * 注入表达式结果
     */
    @Value("#{ T(java.lang.Math).random() * 100.0}")
    private double randomNumber;

    /**
     * 注入其他Bean属性
     */
    @Value("#{elService.another}")
    private String fromAnother;

    /**
     * 注入文件资源
     */
    @Value("classpath:/com/springboot/actualcombat/springconfigure/el/el.text")
    private Resource testFile;

    /**
     * 注入网址资源
     */
    @Value("http://mvnrepository.com")
    private Resource testUrl;

    /**
     * 注入配置文件
     * <p>
     * 注入配置文件需要是@PropertySource()指定文件地址
     * 若用@Value()注入，需要配置一个PropertySourcesPlaceholderConfigurer的Bean。
     * 注意此时使用@Value("${book.name}")使用的是 '$' 而不是 '#'
     */
    @Value("${book.name}")
    private String bookName;

    /**
     * 注入properties可以使用 Environment 获得
     */
    @Autowired
    private Environment environment;

    @Bean
    private static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    public void outputResource() {
        try {
            System.out.println(normal);
            System.out.println(osName);
            System.out.println(randomNumber);
            System.out.println(fromAnother);
            System.out.println(IOUtils.toString(testFile.getInputStream(), "UTF-8"));
            System.out.println(IOUtils.toString(testUrl.getInputStream(), "UTF-8"));
            System.out.println(bookName);
            System.out.println(environment.getProperty("book.auth"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

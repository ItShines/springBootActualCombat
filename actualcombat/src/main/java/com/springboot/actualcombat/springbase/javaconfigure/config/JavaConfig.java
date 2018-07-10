package com.springboot.actualcombat.springbase.javaconfigure.config;

import com.springboot.actualcombat.springbase.javaconfigure.service.FunctionService;
import com.springboot.actualcombat.springbase.javaconfigure.service.UseFunctionService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 配置类
 * 使用@Configuration 声明当前类是一个配置类,这意味着这个类里面有0个或多个@Bean个注解
 * 此处不使用注解，由于所有的Bean都在类中定义了
 *
 * @author Future
 */
@Configuration
public class JavaConfig {

    /**
     * 使用@Bean注解声明当前方法FunctionService的返回值是一个Bean,Bean的名称是方法名
     *
     * @return
     */
    @Bean
    public FunctionService functionService() {
        return new FunctionService();
    }

    @Bean
    public UseFunctionService useFunctionService() {
        UseFunctionService useFunctionService = new UseFunctionService();
        //注入FunctionService的Bean的时候直接调用functionService()
        useFunctionService.setFunctionService(functionService());
        return useFunctionService;
    }

    /**
     * 此种方式注入方式是直接将FunctionService作为参数传个useFunctionService(),这也是Spring容器提供的极好方法
     * 在Spring容器中,只要在容器中存在某个Bean,就可以在另外一个Bean的声明方法的参数中写入。
     *
     * @param functionService
     * @return
     */
    @Bean
    public UseFunctionService useFunctionService(FunctionService functionService) {
        UseFunctionService useFunctionService = new UseFunctionService();
        useFunctionService.setFunctionService(functionService);
        return useFunctionService;
    }
}

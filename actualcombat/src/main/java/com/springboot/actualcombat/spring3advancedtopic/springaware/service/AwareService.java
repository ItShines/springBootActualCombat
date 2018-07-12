package com.springboot.actualcombat.spring3advancedtopic.springaware.service;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * Spring Aware演示Bean 实现类
 * 实现BeanNameAware,ResourceLoaderAware接口，获得Bean的名称和资源加载的服务
 *
 * @author Future
 */
@Service
public class AwareService implements BeanNameAware, ResourceLoaderAware {

    private String beanName;
    private ResourceLoader resourceLoader;

    /**
     * 实现BeanNameAware接口需要重写setBeanName()方法
     *
     * @param beanName
     */
    @Override
    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

    /**
     * 实现ResourceLoaderAware接口需要重写setResourceLoader()方法
     *
     * @param resourceLoader
     */
    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    public void outpResult() {
        System.out.println("Bean的名称为：" + beanName);
        Resource resource = resourceLoader.getResource("classpath:springaware/aware.txt");
        try {
            System.out.println("ResourceLoader加载的文件内容是："
                    + IOUtils.toString(resource.getInputStream(), "UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

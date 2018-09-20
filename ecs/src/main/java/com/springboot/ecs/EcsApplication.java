package com.springboot.ecs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author wb-ryd460712
 */
@SpringBootApplication
public class EcsApplication {


    public static void main(String[] args) {
        SpringApplication.run(EcsApplication.class, args);

    }
}

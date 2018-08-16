package com.springboot.api.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author Future
 */
@Component
@PropertySource("classpath:magic-value.properties")
public class MagicValueConstant {
    @Value("${magicVlaue.zero}")
    public static String zero;

    @Value("${magicVlaue.one}")
    public static String one;

    @Value("${magicVlaue.one}")
    public static String two;

    @Value("${magicVlaue.one}")
    public static String three;
}

package com.springboot.api.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

/**
 * @author Future
 */
@PropertySource("classpath:magic-value.properties")
public class MagicValueConstant {
    @Value("${magicVlaue.one}")
    public static String one;

    @Value("${magicVlaue.one}")
    public static String two;

    @Value("${magicVlaue.one}")
    public static String three;
}

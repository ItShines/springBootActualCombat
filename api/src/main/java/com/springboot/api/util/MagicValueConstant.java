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
    /**
     * String
     */
    @Value("${magicVlaue.zero}")
    public static String zero;

    @Value("${magicVlaue.one}")
    public static String one;

    @Value("${magicVlaue.two}")
    public static String two;

    @Value("${magicVlaue.three}")
    public static String three;

    /**
     * int
     */
    @Value("${magicVlaue.zero}")
    public static int intZero;

    @Value("${magicVlaue.one}")
    public static int intOne;

    @Value("${magicVlaue.two}")
    public static int intTwo;

    @Value("${magicVlaue.three}")
    public static int intThree;
}

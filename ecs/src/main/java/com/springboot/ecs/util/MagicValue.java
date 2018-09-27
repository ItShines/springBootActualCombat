package com.springboot.ecs.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author Future
 */
@Component
@PropertySource("classpath:magic-value.properties")
public class MagicValue {
    /**
     * String
     */
    @Value("${magicValue.zero}")
    public static String zero;

    @Value("${magicValue.one}")
    public static String one;

    @Value("${magicValue.two}")
    public static String two;

    @Value("${magicValue.three}")
    public static String three;

    @Value("${magicValue.four}")
    public static String four;

    @Value("${magicValue.five}")
    public static String five;
    /**
     * int
     */
    @Value("${magicValue.zero}")
    public static int intZero;

    @Value("${magicValue.one}")
    public static int intOne;

    @Value("${magicValue.two}")
    public static int intTwo;

    @Value("${magicValue.three}")
    public static int intThree;

    @Value("${magicValue.four}")
    public static int intFour;

    @Value("${magicValue.five}")
    public static int intFive;
}

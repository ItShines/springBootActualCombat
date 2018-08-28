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
    @Value("${magicValue.zero}")
    public static String zero;

    @Value("${magicValue.one}")
    public static String one;

    @Value("${magicValue.two}")
    public static String two;

    @Value("${magicValue.three}")
    public static String three;

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
}

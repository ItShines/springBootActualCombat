package com.springboot.api.util;

import org.springframework.context.annotation.PropertySource;

/**
 * @author Future
 */
@PropertySource("classpath:magic-value.properties")
public class MagicValueConstant {
    public static String one;
    public static String two;
    public static String three;
}

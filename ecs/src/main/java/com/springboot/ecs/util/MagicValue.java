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
    public String zero;

    @Value("${magicValue.one}")
    public String one;

    @Value("${magicValue.two}")
    public String two;

    @Value("${magicValue.three}")
    public String three;

    @Value("${magicValue.four}")
    public String four;

    @Value("${magicValue.five}")
    public String five;
    /**
     * int
     */
    @Value("${magicValue.zero}")
    public int intZero;

    @Value("${magicValue.one}")
    public int intOne;

    @Value("${magicValue.two}")
    public int intTwo;

    @Value("${magicValue.three}")
    public int intThree;

    @Value("${magicValue.four}")
    public int intFour;

    @Value("${magicValue.five}")
    public int intFive;


}

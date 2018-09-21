package com.springboot.actualcombat.spring3advancedtopic.condition.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * 1 判断Macos条件
 *
 * @author Future
 */
public class MacosCondition implements Condition {
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        String property = conditionContext.getEnvironment().getProperty("os.name");
        System.out.println(property);
        return conditionContext.getEnvironment().getProperty("os.name").contains("Mac OS X");
    }
}

package com.springboot.actualcombat.spring3advancedtopic.junit;

import com.springboot.actualcombat.spring3advancedtopic.junit.bean.TestBean;
import com.springboot.actualcombat.spring3advancedtopic.junit.config.TestConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * SpringJUnit4ClassRunner在JUnit环境下提供Spring TestContext Framework的功能。
 * ContextConfiguration用来加载配置ApplicationContext,其中classes属性用来加载配置类
 * ActiveProfiles用来声明活动的profile
 * Autowired 普通注入Bean
 * Test测试代码，通过JUnit的Assert来验证结果是否与预期一致。
 *
 * @author Future
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestConfig.class})
@ActiveProfiles("prod")
public class JunitTest {

    @Autowired
    private TestBean testBean;

    @Test
    public void prodBeanShouldInject() {
        String expected = "from production profile";
        String context = testBean.getContext();
        Assert.assertEquals(expected, context);
    }
}

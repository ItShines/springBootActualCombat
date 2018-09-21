package com.springboot.actualcombat.spring2configure.profile.config;

import com.springboot.actualcombat.spring2configure.profile.bean.ProfileBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * 2.配置Profile
 *
 * @author Future
 */
@Configuration
public class ProfileConfig {

    /**
     * Profile 为dev时 实例化devProfileBean.
     *
     * @return
     */
    @Bean
    @Profile("dev")
    public ProfileBean devProfileBean() {
        return new ProfileBean("from development profile");
    }

    /**
     * Profile 为prod时 实例化prodProfileBean
     *
     * @return
     */
    @Bean
    @Profile("prod")
    public ProfileBean prodProfileBean() {
        return new ProfileBean("from production profile");
    }
}

package com.atuts.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Class to provide spring security configurations.
 *
 */
@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     *  store and manage user credentials.
     *  to configure roles use authorities() or roles() method.
     *
     **/
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder authenticationManagerBuilder){
        //configure spring security
    }

    /**
     * method to configure spring security.
     *
     * @param httpSecurity
     */
    @Override
    protected void configure(HttpSecurity httpSecurity){
        //configure spring security
    }
}

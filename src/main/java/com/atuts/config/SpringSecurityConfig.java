package com.atuts.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by BurusothmanA on 3/15/2016 11:41 AM.
 */
@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     *  store and manage user credentials.
     *  to configure roles use authorities() or roles() method.
     **/
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder authenticationManagerBuilder){

    }

    @Override
    protected void configure(HttpSecurity httpSecurity){

    }
}

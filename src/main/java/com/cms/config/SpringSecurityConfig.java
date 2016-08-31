package com.cms.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

/**
 * Class to provide spring security configurations.
 *
 */
@Configuration
@EnableWebSecurity
@Import(SpringWebConfig.class)
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;
    /**
     *  store and manage user credentials.
     *  to configure roles use authorities() or roles() method.
     *
     **/
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        //configure spring security
        authenticationManagerBuilder.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery("select username,password, enabled from users where username=?")
                .authoritiesByUsernameQuery("select username, role from user_roles where username=?");
    }

    /**
     * method to configure spring security.
     *
     * @param httpSecurity
     */
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        //configure spring security
        httpSecurity.authorizeRequests().antMatchers("/admin").access("hasRole('ROLE_ADMIN')")
                .antMatchers("/home").access("hasRole('ROLE_USER')")
                .antMatchers("/home").access("hasRole('ROLE_ADMIN')")
        .and()
            .formLogin().loginPage("/login")
            .defaultSuccessUrl("/home")
            .failureUrl("/login?error=authentication_failed")
            .usernameParameter("username").passwordParameter("password")
            .and().csrf()
        .and()
            .logout().logoutSuccessUrl("/login?logout").and()
            .exceptionHandling().accessDeniedPage("/403.jsp");

        httpSecurity.csrf().disable();
    }

}

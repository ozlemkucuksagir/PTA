package com.smartIct.PublicTransport.Security.Config;
/*
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class DemoConf extends WebSecurityConfigurerAdapter{

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http)  throws Exception {

        return http
                .authorizeRequests(configurer ->
                        configurer
                                .antMatchers("/").hasRole("EMPLOYEE")
                                .antMatchers("/leaders/**").hasRole("MANAGER")
                                .antMatchers("/systems/**").hasRole("ADMIN"))

                .formLogin(configurer ->
                        configurer
                                .loginPage("/showMyLoginPage")
                                .loginProcessingUrl("/authenticateTheUser")
                                .permitAll())

                .logout(configure ->
                        configure
                                .permitAll())
                .exceptionHandling(configurer ->
                        configurer
                                .accessDeniedPage("/access-denied"))
                .build();
    }
}
*/
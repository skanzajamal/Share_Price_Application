package com.config;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;


@EnableOAuth2Sso
@Configuration
public class OAuth2Configuration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception{

        http
                .authorizeRequests(a->a
                .antMatchers("/**","/login**", "/h2","/list","/error","/webjars/**").permitAll()
                .anyRequest().authenticated()
                )
                .logout(l->l
                        .logoutSuccessUrl("/").permitAll())
                .exceptionHandling(e-> e
                    .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED)))
                .oauth2Login();
    }

} //ENDCLASS



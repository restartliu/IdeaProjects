package com.test.springsecurity.config;

import com.test.springsecurity.handler.MyAuthenticationFailureHandler;
import com.test.springsecurity.handler.MyAuthenticationSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AccessDeniedHandler myAccessDeniedHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .usernameParameter("username123")
                .passwordParameter("password123")
                .loginPage("/demo/login.html")
                .loginProcessingUrl("/demo/login")
                .successHandler(new MyAuthenticationSuccessHandler("/demo/toMain"))
                .failureHandler(new MyAuthenticationFailureHandler("/demo/toError"));

        http.authorizeRequests()
                .antMatchers("/demo/login.html", "/demo/toError", "/demo/error.html").permitAll()
                .anyRequest().authenticated();

        http.exceptionHandling()
                .accessDeniedHandler(this.myAccessDeniedHandler);

        http.csrf().disable();
    }

    @Bean
    public PasswordEncoder getPw(){
        return new BCryptPasswordEncoder();
    }

}

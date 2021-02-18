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

                // the keyword to get username and password from login page can changed by this config
                .usernameParameter("username123")
                .passwordParameter("password123")

                // login page and pass data to
                .loginPage("/demo/login.html")
                .loginProcessingUrl("/demo/login")

                // spring security provide method (my way) to access successful(failure) situation
                .successForwardUrl("/demo/toMain")
                //.successHandler(new MyAuthenticationSuccessHandler("/demo/main.html"))
                .failureForwardUrl("/demo/toError");
                //.failureHandler(new MyAuthenticationFailureHandler("/demo/error.html"));

        http.authorizeRequests()

                // static resources may not be compiled to target
                // you can delete target directory then compile again
                // you can also move the static resources to target directory

                // release static resources according to file path
                .antMatchers("/**/*.png").permitAll()

                // according to regex expression
                //.regexMatchers(".+[.]png").permitAll()
                // according to the request method and regex expression
                .regexMatchers("get", ".+[.]png").permitAll()

                // there are multiple authentications for request, you can check their usage on the internet
                .antMatchers("/demo/login.html").permitAll()
                .antMatchers("/demo/error.html").permitAll()
                .antMatchers("/demo/access").access("permitAll")

                // every authentication method call the access method to implement them
                // put the name of authentication method into the parameter of the access method to have the same effect
                .mvcMatchers("/fuck").servletPath("/demo").access("permitAll")

                // access control by role and authority
                // these roles and authorities can be added by class UserDetailServiceImpl
                .antMatchers("/demo/main1.html").hasAnyAuthority("admin", "admiN")
                //.antMatchers("/demo/main2.html").hasAuthority("admiN")
                .antMatchers("/demo/main2.html").hasAnyRole("abc", "abC")

                // access control by ip address
                .antMatchers("/demo/main1.html").hasIpAddress("127.0.0.1")

                //.anyRequest().authenticated();
                // DIY access method
                .anyRequest().access("@myServiceImpl.hasPermission(request, authentication)");
                //.anyRequest().authenticated();

        // DIY access denied handler
        http.exceptionHandling()
                .accessDeniedHandler(this.myAccessDeniedHandler);

        // release cross domain request (I don't know if it is true)
        http.csrf().disable();
    }

    @Bean
    // make password process object be managed by spring factory
    public PasswordEncoder getPw(){
        return new BCryptPasswordEncoder();
    }

}

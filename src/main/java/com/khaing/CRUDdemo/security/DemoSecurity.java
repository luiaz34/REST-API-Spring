package com.khaing.CRUDdemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class DemoSecurity {
    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){
        UserDetails john = User.builder()
            .username("john")
            .password("{noop}123")
            .roles("employee","manager")
            .build();

         UserDetails may= User.builder()
            .username("may")
            .password("123")
            .roles("employee","manager","CEO")
            .build();

        return new InMemoryUserDetailsManager(john, may);
    }
}
 
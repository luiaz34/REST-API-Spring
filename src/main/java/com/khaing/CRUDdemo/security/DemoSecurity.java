package com.khaing.CRUDdemo.security;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class DemoSecurity {
    // @Bean
    // public InMemoryUserDetailsManager userDetailsManager(){
    //     UserDetails john = User.builder()
    //         .username("john")
    //         .password("{noop}123")
    //         .roles("EMPLOYEE")
    //         .build();

    //     UserDetails may=User.builder()
    //         .username("may")
    //         .password("{noop}123")
    //         .roles("EMPLOYEE","MANAGER")
    //         .build();
        
    //     UserDetails jerry=User.builder()
    //         .username("jerry")
    //         .password("{noop}123")
    //         .roles("EMPLOYEE","MANAGER","ADMIN")
    //         .build();


    //     return new InMemoryUserDetailsManager(john, may, jerry);
    // }
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){
        return new JdbcUserDetailsManager(dataSource);
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(authz -> authz
                .requestMatchers(HttpMethod.GET, "/api/employees").hasAnyRole("EMPLOYEE", "MANAGER", "ADMIN")
                .requestMatchers(HttpMethod.GET, "/api/employees/**").hasAnyRole("EMPLOYEE", "MANAGER", "ADMIN")
                .requestMatchers(HttpMethod.POST, "/api/employees").hasAnyRole("MANAGER", "ADMIN")
                .requestMatchers(HttpMethod.PUT, "/api/employees").hasAnyRole("MANAGER", "ADMIN")
                .requestMatchers(HttpMethod.DELETE, "/api/employees/**").hasRole("ADMIN")
            )
            .httpBasic(Customizer.withDefaults())
            .csrf(csrf -> csrf.disable());

        return http.build();
    }


}
 
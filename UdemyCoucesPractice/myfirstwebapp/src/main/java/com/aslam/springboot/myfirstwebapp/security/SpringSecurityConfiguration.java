package com.aslam.springboot.myfirstwebapp.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.function.Function;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SpringSecurityConfiguration {
    //todo LDAP or database
    //todo In Memory

    @Bean
    public InMemoryUserDetailsManager createUserDetailsManager() {
        UserDetails userDetails1 = CreateNewUser("aslam", "dummy");
        UserDetails userDetails2 = CreateNewUser("in28minutes", "dummy");
        return new InMemoryUserDetailsManager(userDetails1, userDetails2);
    }

    private UserDetails CreateNewUser(String username, String password) {

        Function<String, String> passwordEncode =
                input -> passwordEncoder().encode(input);
        UserDetails userDetails = User.builder()//User.withDefaultPasswordEncoder() --deprecated
                .passwordEncoder(passwordEncode)
                .username(username)
                .password(password)
                .roles("USER", "ADMIN")
                .build();
        return userDetails;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests(
                auth -> auth.anyRequest().authenticated());
        httpSecurity.formLogin(withDefaults());
        httpSecurity.csrf().disable(); //todo need to removed later
        httpSecurity.headers().frameOptions().disable();
        return httpSecurity.build();
    }
}

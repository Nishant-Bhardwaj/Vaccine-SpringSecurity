package com.nishant.Vaccine.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class MySecurityConfig extends WebSecurityConfigurerAdapter {


    private final PasswordEncoder passwordEncoder;

    @Autowired
    public MySecurityConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable();

        http
                .authorizeRequests()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin();
        
//        http.formLogin().disable();
    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {

        UserDetails nishantUser = User.builder()
                .username("nishant")
                .password(passwordEncoder.encode("Talent@2020"))
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(
                nishantUser
        );

    }

}

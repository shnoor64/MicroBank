package com.simbirsoft.belousov.microbank.config;

import com.simbirsoft.belousov.microbank.services.PersonalAccountDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    final PersonalAccountDetailsService personalAccountDetailsService;

    public SecurityConfig(PersonalAccountDetailsService personalAccountDetailsService) {
        this.personalAccountDetailsService = personalAccountDetailsService;
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests().anyRequest().authenticated()
                .and().httpBasic()
                .and().sessionManagement().disable();
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();

//        return new PasswordEncoder() {
//            @Override
//            public String encode(CharSequence charSequence) {
//                return "oleg";
//            }
//
//            @Override
//            public boolean matches(CharSequence charSequence, String s) {
//                return true;
//            }
//        };
    }

    @Override
    public void configure(AuthenticationManagerBuilder builder)throws Exception{
        builder.userDetailsService(personalAccountDetailsService);
    }
}
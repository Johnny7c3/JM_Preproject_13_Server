package ru.javamentor.preproject.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.logging.Logger;

@Configuration
@EnableWebSecurity
@ComponentScan("ru.javamentor.preproject")
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private static Logger log = Logger.getLogger(SecurityConfig.class.getName());
    private PasswordEncoder passwordEncoder;

    @Autowired
    public SecurityConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

@Autowired
public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
        log.info("configureGlobalSecurity");
        auth.inMemoryAuthentication()
        .withUser("admin").password(passwordEncoder.encode("admin")).roles("ADMIN");
        }

@Override
protected void configure(HttpSecurity http) throws Exception {
        log.info("configure(HttpSecurity http)");
        http
        .httpBasic()
        .and()
        .authorizeRequests()
        .antMatchers("/admin/**").hasRole("ADMIN")
        .and()
        .csrf().disable()
        .formLogin().disable();
        }
}

package com.login.loginwebservice.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class LoginSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailsService userDetailsService;

    /* @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Override
	  protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
        .antMatchers("/login").permitAll()
        .and()
          .formLogin()
          .loginPage("/login")
          .loginProcessingUrl("/process-login")
          .defaultSuccessUrl("/home")
          .failureUrl("/login?error=true")
          .permitAll();
	  } */

    @Autowired
    private PasswordEncoder passwordEncoder; 
      
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception { 
        auth.inMemoryAuthentication() 
        .withUser("admin") 
        .password(passwordEncoder.encode("admin123")) 
        .roles("admin"); 
    } 
      
    // Configuring basic authentication through configure method 
    @Override
    protected void configure(HttpSecurity http) throws Exception { 
        http.authorizeRequests()
        .antMatchers("/home", "/reset").authenticated() 
        .antMatchers("/login", "/register").permitAll() 
            .and() 
            .formLogin().loginPage("/login") 
            .and() 
            .httpBasic(); 
    } 

    @Bean
    public PasswordEncoder passwordEncoder() {
      return new BCryptPasswordEncoder();
    }
}
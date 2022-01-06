package com.joaoiora.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;

/**
 * @author João Iora
 */
@Configuration
@EnableWebSecurity
public class SpringSecurityConfiguration
  extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(AuthenticationManagerBuilder auth)
    throws Exception {
    final var users = User.withDefaultPasswordEncoder();
    auth.inMemoryAuthentication()
        .withUser(users.username("john").password("john").roles("EMPLOYEE"))
        .withUser(users.username("mary").password("mary").roles("EMPLOYEE",
                                                                "MANAGER"))
        .withUser(users.username("susan").password("susan").roles("EMPLOYEE",
                                                                  "ADMIN"));
  }

  @Override
  protected void configure(HttpSecurity http)
    throws Exception {
    http.authorizeRequests().antMatchers("/resources/**").permitAll()
        .antMatchers("/leaders/**").hasRole("MANAGER")
        .antMatchers("/systems/**").hasRole("ADMIN").anyRequest()
        .authenticated().and().formLogin().loginPage("/showLoginPage")
        .loginProcessingUrl("/authenticate").permitAll().and()
        .exceptionHandling().accessDeniedPage("/access-denied").and().logout()
        .permitAll();
  }

}

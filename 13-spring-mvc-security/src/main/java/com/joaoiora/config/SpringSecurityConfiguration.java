package com.joaoiora.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author João Iora
 */
@Configuration
@EnableWebSecurity
public class SpringSecurityConfiguration
  extends WebSecurityConfigurerAdapter {

  /**
   *
   */
  @Autowired
  private DataSource dataSource;

  @Override
  protected void configure(AuthenticationManagerBuilder auth)
    throws Exception {
    auth.jdbcAuthentication().dataSource(dataSource);
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

  @Bean
  public DaoAuthenticationProvider getDaoAuthenticationProvider() {
    final var provider = new DaoAuthenticationProvider();
    // provider.setUserDetailsService(userDetailsService);
    provider.setPasswordEncoder(newBCryptPasswordEncoder());
    return provider;
  }

  @Bean
  public BCryptPasswordEncoder newBCryptPasswordEncoder() {
    return new BCryptPasswordEncoder();
  }

}

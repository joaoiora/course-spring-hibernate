package com.joaoiora.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author João Iora
 */
@Configuration
@EnableWebMvc
@ComponentScan(value = "com.joaoiora")
public class AppConfiguration {

}

package com.joaoiora;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author João Iora
 */
@Configuration
@EnableAspectJAutoProxy
@ComponentScan(value = "com.joaoiora")
public class AOPConfig {

}

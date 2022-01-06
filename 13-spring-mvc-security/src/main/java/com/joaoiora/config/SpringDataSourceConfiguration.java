package com.joaoiora.config;

import java.beans.PropertyVetoException;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * @author João Iora
 */
@Configuration
@PropertySource(value = "classpath:jdbc.properties")
public class SpringDataSourceConfiguration {

  /**
   *
   */
  private static final Logger LOG = Logger
      .getLogger(SpringDataSourceConfiguration.class.getName());

  /**
   *
   */
  @Autowired
  private Environment env;

  /**
   * @return
   */
  @Bean
  public DataSource getSecurityDataSource() {
    final var dataSource = new ComboPooledDataSource();
    try {
      dataSource.setDriverClass(getProperty("jdbc.driver"));
    }
    catch (final PropertyVetoException e) {
      throw new RuntimeException(e.getMessage(), e);
    }
    dataSource.setJdbcUrl(getProperty("jdbc.url"));
    dataSource.setUser(getProperty("jdbc.user"));
    dataSource.setPassword(getProperty("jdbc.password"));
    dataSource
        .setInitialPoolSize(getIntProperty("connection.pool.initialPoolSize"));
    dataSource.setMinPoolSize(getIntProperty("connection.pool.minPoolSize"));
    dataSource.setMaxPoolSize(getIntProperty("connection.pool.maxPoolSize"));
    dataSource.setMaxIdleTime(getIntProperty("connection.pool.maxIdleTime"));
    LOG.info(">> DataSource: " +
             dataSource);
    return dataSource;
  }

  /**
   * @param key
   *
   * @return
   */
  private String getProperty(String key) {
    return env.getProperty(key);
  }

  /**
   * @param key
   *
   * @return
   */
  private Integer getIntProperty(String key) {
    final var value = getProperty(key);
    try {
      return Integer.parseInt(value);
    }
    catch (final NumberFormatException e) {
      LOG.warning(">> Could not parse '" +
                  value +
                  "' to Integer.");
    }
    return null;
  }

}

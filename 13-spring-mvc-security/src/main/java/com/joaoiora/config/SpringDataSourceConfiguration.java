package com.joaoiora.config;

import java.beans.PropertyVetoException;
import java.util.Properties;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * @author João Iora
 */
@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = "com.joaoiora")
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
  public DataSource getDataSource() {
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
    return dataSource;
  }

  /**
   * @return
   */
  private Properties getHibernateProperties() {
    final var props = new Properties();
    props.setProperty("hibernate.dialect",
                      getProperty("hibernate.dialect"));
    props.setProperty("hibernate.show_sql",
                      getProperty("hibernate.show_sql"));
    return props;
  }

  /**
   * @return
   */
  @Bean
  public LocalSessionFactoryBean sessionFactory() {
    final var sessionFactory = new LocalSessionFactoryBean();
    sessionFactory.setDataSource(getDataSource());
    sessionFactory.setPackagesToScan(getProperty("hibernate.packagesToScan"));
    sessionFactory.setHibernateProperties(getHibernateProperties());
    return sessionFactory;
  }

  /**
   * @param sessionFactory
   *
   * @return
   */
  @Autowired
  @Bean
  public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
    final var transactionManager = new HibernateTransactionManager();
    transactionManager.setSessionFactory(sessionFactory);
    return transactionManager;
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

package com.joaoiora.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author João Iora
 */
@Aspect
@Component
@Order(value = 1)
public class CloudAsyncLoggingAspect {

  /**
  *
  */
  @Before(value = "com.joaoiora.aspect.CommonAopExpressions.forDaoPackageNoGetterSetter()")
  public void logToCloudAsync() {
    System.out.println(">> Executing @Before at LogginAspect#logToCloudAsync().");
  }

}

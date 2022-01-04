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
@Order(value = 3)
public class ApiAnalyticsAspect {

  /**
  *
  */
  @Before(value = "com.joaoiora.aspect.CommonAopExpressions.forDaoPackageNoGetterSetter()")
  public void performApiAnalytics() {
    System.out.println(">> Executing @Before at LogginAspect#performApiAnalytics().");
  }

}

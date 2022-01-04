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
@Order(value = 2)
public class DefaultLoggingAspect {

  /**
  *
  */
  // @Before(value = "execution(public void addAccount())")
  // @Before(value = "execution(public void updateAccount())")
  // @Before(value = "execution(public void com.joaoiora.dao.AccountDAO.addAccount())")
  // @Before(value = "execution(* add*())")
  // @Before(value = "execution(public void add*(com.joaoiora.Account))")
  // @Before(value = "execution(public void add*(com.joaoiora.Account, ..))")
  // @Before(value = "execution(public void add*(Account))")
  // @Before(value = "execution(public void add*(..))")
  // @Before(value = "execution(* com.joaoiora.dao.*.*(..))")
  @Before(value = "com.joaoiora.aspect.CommonAopExpressions.forDaoPackageNoGetterSetter()")
  public void beforeAddAccountAdvice() {
    // System.out.println(">> Executing @Before at LogginAspect#beforeAddAccountAdvice().");
    System.out.println(">> Executing @Before at LogginAspect#beforeAddAccountAdvice(), using @Pointcut declaration.");
  }

}

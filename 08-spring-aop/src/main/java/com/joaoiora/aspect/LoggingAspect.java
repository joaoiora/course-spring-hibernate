package com.joaoiora.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author João Iora
 */
@Aspect
@Component
public class LoggingAspect {

  @Pointcut(value = "execution(* com.joaoiora.dao.*.add*(com.joaoiora.Account))")
  public void forDaoPackage() {

  }

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
  @Before(value = "forDaoPackage()")
  public void beforeAddAccountAdvice() {
    System.out.println(">> Executing @Before at LogginAspect#beforeAddAccountAdvice().");
  }

}

package com.joaoiora.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.joaoiora.Account;

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
  @Before(value = "com.joaoiora.aspect.CommonAopExpressions.forDaoPackageNoGetterSetter()")
  public void beforeAddAccountAdvice() {
    System.out.println(">> Executing @Before at LogginAspect#beforeAddAccountAdvice().");
  }

  /**
   * @param joinPoint
   * @param accounts
   */
  @AfterReturning(pointcut = "execution(* com.joaoiora.dao.AccountDAO.findAccounts())",
                  returning = "accounts")
  public void afterReturningOnFindAccounts(JoinPoint joinPoint, List<Account> accounts) {
    final var methodName = joinPoint.getSignature().toShortString();
    System.out.println(">> Executing @AfterReturning on method: " +
                       methodName);
    System.out.println(">> Accounts @AfterReturning are: " +
                       accounts);
    convertAccountNamesToUpperCase(accounts);
    System.out.println(">> Accounts on @AfterReturning, after convertin Account Names are: " +
                       accounts);
  }

  /**
   * @param joinPoint
   * @param exception
   */
  @AfterThrowing(pointcut = "execution(* com.joaoiora.dao.AccountDAO.findAccountsThatThrowsException())",
                 throwing = "exception")
  public void afterThrowingOnFindAccounts(JoinPoint joinPoint, Exception exception) {
    final var methodName = joinPoint.getSignature().toShortString();
    System.out.println(">> Executing @AfterThrowing on method: " +
                       methodName);
    System.out.println(">> Caught exception is: " +
                       exception);
  }

  /**
   * @param joinPoint
   */
  @After(value = "execution(* com.joaoiora.dao.AccountDAO.find*())")
  @Order(value = 1)
  public void afterFinallyOnFindAccounts(JoinPoint joinPoint) {
    final var methodName = joinPoint.getSignature().toShortString();
    System.out.println(">> Executing @After on method: " +
                       methodName);
  }

  /**
   * @param joinPoint
   */
  @After(value = "execution(* com.joaoiora.dao.AccountDAO.find*())")
  @Order(value = 2)
  public void anotherAfterFinallyOnFindAccounts(JoinPoint joinPoint) {
    final var methodName = joinPoint.getSignature().toShortString();
    System.out.println(">> Executing another @After on method: " +
                       methodName);
  }

  /**
   * @param accounts
   */
  private void convertAccountNamesToUpperCase(List<Account> accounts) {
    accounts.forEach(account -> account.setName(account.getName().toUpperCase()));
  }

}

package com.joaoiora.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author João Iora
 */
@Aspect
@Component
public class CRMLoggingAspect {

  /**
   *
   */
  private static final Logger LOG = Logger.getLogger(CRMLoggingAspect.class.getName());

  /**
   * @param joinPoint
   */
  @Before(value = "forAppFlow()")
  public void before(JoinPoint joinPoint) {
    LOG.info(">> Inside @Before Advice, executing method: " +
             joinPoint.getSignature().toShortString());
    for (final Object arg : joinPoint.getArgs()) {
      LOG.info(">> Method Argument: " +
               arg);
    }
    LOG.info("----------------------------------------------------------------------------------------------------");
  }

  /**
   * @param joinPoint
   * @param result
   */
  @AfterReturning(pointcut = "forAppFlow()",
                  returning = "result")
  public void afterReturning(JoinPoint joinPoint, Object result) {
    LOG.info(">> Inside @AfterReturning Advice, executing method: " +
             joinPoint.getSignature().toShortString());
    System.out.println(">> The @AfterReturning result: " +
                       result);
  }

  /**
   *
   */
  @Pointcut(value = "forDaoPackage() || forServicePackage() || forControllerPackage()")
  private void forAppFlow() {

  }

  /**
   *
   */
  @Pointcut(value = "execution(* com.joaoiora.controller.*.*(..))")
  private void forControllerPackage() {

  }

  /**
   *
   */
  @Pointcut(value = "execution(* com.joaoiora.service.*.*(..))")
  private void forServicePackage() {

  }

  /**
   *
   */
  @Pointcut(value = "execution(* com.joaoiora.dao.*.*(..))")
  private void forDaoPackage() {

  }

}

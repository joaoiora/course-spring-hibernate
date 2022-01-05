package com.joaoiora.aspect;

import java.util.stream.Stream;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
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
   * @param joinPoint
   */
  @Before(value = "com.joaoiora.aspect.CommonAopExpressions.forDaoPackageNoGetterSetter()")
  public void beforeAddAccountAdvice(JoinPoint joinPoint) {
    System.out.println(">> Executing @Before at LogginAspect#beforeAddAccountAdvice(), using @Pointcut declaration.");
    if (joinPoint.getSignature() instanceof MethodSignature) {
      final var signature = (MethodSignature) joinPoint.getSignature();
      System.out.println("Method: " +
                         signature);
    }
    Stream.of(joinPoint.getArgs()).forEach(arg -> {
      if (arg instanceof Account) {
        System.out.println("Account Name/Level: " +
                           (arg));
      }
    });
  }

}

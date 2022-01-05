package com.joaoiora.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
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
  private static final Logger LOG = Logger.getLogger(DefaultLoggingAspect.class.getName());

  /**
   * @param joinPoint
   *
   * @return
   *
   * @throws Throwable
   */
  @Around(value = "execution(* com.joaoiora.service.*.getFortune*())")
  public Object aroundAdviceOnGettingFortune(ProceedingJoinPoint joinPoint)
    throws Throwable {
    final var methodName = joinPoint.getSignature().toShortString();
    LOG.info(">> Executing @Around on method: " +
             methodName);
    final var begin = System.currentTimeMillis();
    Object result = null;
    try {
      result = joinPoint.proceed();
    }
    catch (final Exception e) {
      LOG.warning("@Around Advice threw an exception: " +
                  e.getMessage());
      // result = "Major Acident! Your private AOP helicopter is on the way.";
      throw e;
    }
    final var end = System.currentTimeMillis();
    final var duration = (end - begin) / 1000.0;
    LOG.info(">> It took " +
             duration +
             " seconds to execute the method.");
    return result;
  }

}

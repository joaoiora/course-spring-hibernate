package com.joaoiora.aspect;

import org.aspectj.lang.annotation.Pointcut;

/**
 * @author João Iora
 */
// @Aspect
public class CommonAopExpressions {

  /**
  *
  */
  @Pointcut(value = "execution(* com.joaoiora.dao.*.*(..))")
  public void forDaoPackage() {

  }

  /**
  *
  */
  @Pointcut(value = "execution(* com.joaoiora.dao.*.get*(..))")
  public void getter() {

  }

  /**
  *
  */
  @Pointcut(value = "execution(* com.joaoiora.dao.*.set*(..))")
  public void setter() {

  }

  /**
  *
  */
  @Pointcut(value = "forDaoPackage() && !(getter() || setter())")
  public void forDaoPackageNoGetterSetter() {

  }

}

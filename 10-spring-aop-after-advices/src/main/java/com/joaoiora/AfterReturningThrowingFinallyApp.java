package com.joaoiora;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.joaoiora.dao.AccountDAO;

/**
 * @author João Iora
 */
public class AfterReturningThrowingFinallyApp {

  /**
   * @param args
   */
  public static void main(String[] args) {
    try (var context = new AnnotationConfigApplicationContext(AOPConfig.class)) {
      final var dao = context.getBean(AccountDAO.class);
      System.out.println("-----------------------------------------------------------------------");
      try {
        dao.findAccountsThatThrowsException();
      }
      catch (final Exception e) {
        System.out.println("An exception was thrown and caught: " +
                           e);
      }
      System.out.println("-----------------------------------------------------------------------");
      System.out.println(dao.findAccounts());
    }
  }

}

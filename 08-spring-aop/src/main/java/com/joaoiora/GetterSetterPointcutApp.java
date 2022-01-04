package com.joaoiora;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.joaoiora.dao.AccountDAO;

/**
 * @author João Iora
 */
public class GetterSetterPointcutApp {

  /**
   * @param args
   */
  public static void main(String[] args) {
    try (var context = new AnnotationConfigApplicationContext(AOPConfig.class)) {
      final var account = context.getBean(AccountDAO.class);
      account.addAccount();
      System.out.println("------------------------------------------------------------------------");
      account.addAccount(new Account("Google", "Beginner"));
      System.out.println("------------------------------------------------------------------------");
      account.addAccount(new Account("MasterCard", "Black"),
                         true);
      System.out.println("------------------------------------------------------------------------");
      account.setName("foobar");
      System.out.println("------------------------------------------------------------------------");
      account.setServiceCode("black");
      System.out.println("------------------------------------------------------------------------");
      account.getName();
      System.out.println("------------------------------------------------------------------------");
      account.getServiceCode();
      System.out.println("------------------------------------------------------------------------");
    }
  }

}

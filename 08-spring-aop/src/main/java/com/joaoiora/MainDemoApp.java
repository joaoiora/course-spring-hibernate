package com.joaoiora;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.joaoiora.dao.AccountDAO;
import com.joaoiora.dao.MembershipDAO;

/**
 * @author João Iora
 */
public class MainDemoApp {

  /**
   * @param args
   */
  public static void main(String[] args) {
    try (var context = new AnnotationConfigApplicationContext(AOPDemoConfig.class)) {
      final var account = context.getBean(AccountDAO.class);
      final var membership = context.getBean(MembershipDAO.class);
      account.addAccount();
      System.out.println("------------------------------------------------------------------------");
      account.addAccount(new Account("Google", "Beginner"),
                         false);
      System.out.println("------------------------------------------------------------------------");
      account.addAccount(new Account("MasterCard", "Black"),
                         true);
      System.out.println("------------------------------------------------------------------------");
      account.cancelAccount();
      System.out.println("------------------------------------------------------------------------");
      membership.addMembershipAccount();
      System.out.println("------------------------------------------------------------------------");
      membership.cancelAccount();

    }
  }

}

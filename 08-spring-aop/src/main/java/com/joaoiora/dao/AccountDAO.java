package com.joaoiora.dao;

import org.springframework.stereotype.Component;

import com.joaoiora.Account;

/**
 * @author João Iora
 */
@Component
public class AccountDAO {

  /**
   *
   */
  public void addAccount() {
    System.out.println(getClass() +
                       ": Adding an Account.");
  }

  /**
   * @param account
   * @param vip
   */
  public void addAccount(Account account, boolean vip) {
    final var message = vip ? ": Adding VIP Account: "
                            : ": Adding Account: ";
    System.out.println(getClass() + message + account);
  }

  public void cancelAccount() {
    System.out.println(getClass() +
                       ": Cancelling Account");
  }

}

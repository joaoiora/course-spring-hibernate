package com.joaoiora.dao;

import java.util.List;

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
  private String name;

  /**
   *
   */
  private String serviceCode;

  /**
   * @return
   */
  public List<Account> findAccounts() {
    return List.of(new Account("John", "Bronze"),
                   new Account("Madhu", "Silver"),
                   new Account("Joseph", "Gold"),
                   new Account("Bill", "Platinum"));
  }

  /**
   *
   */
  public void findAccountsThatThrowsException() {
    throw new UnsupportedOperationException("No implementation of this method for you.");
  }

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
  public void addAccount(Account account) {
    System.out.println(getClass() +
                       ": Adding Account: " +
                       account);
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

  /**
   *
   */
  public void cancelAccount() {
    System.out.println(getClass() +
                       ": Cancelling Account");
  }

  /**
   * @return the name
   */
  public String getName() {
    System.out.println(getClass() +
                       ": getName()");
    return name;
  }

  /**
   * @param name the name to set
   */
  public void setName(String name) {
    System.out.println(getClass() +
                       ": setName(String)");
    this.name = name;
  }

  /**
   * @return the serviceCode
   */
  public String getServiceCode() {
    System.out.println(getClass() +
                       ": getServiceCode()");
    return serviceCode;
  }

  /**
   * @param serviceCode the serviceCode to set
   */
  public void setServiceCode(String serviceCode) {
    System.out.println(getClass() +
                       ": setServiceCode(String)");
    this.serviceCode = serviceCode;
  }

}

package com.joaoiora.dao;

import org.springframework.stereotype.Component;

/**
 * @author João Iora
 */
@Component
public class MembershipDAO {

  /**
  *
  */
  public void addMembershipAccount() {
    System.out.println(getClass() +
                       ": Adding a membership Account.");
  }

  /**
   *
   */
  public void cancelAccount() {
    System.out.println(getClass() +
                       ": Cancelling Membership Account");
  }

}

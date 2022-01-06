package com.joaoiora.model;

/**
 * @author João Iora
 */
public class Student {

  /**
  *
  */
  private String firstName;

  /**
  *
  */
  private String lastName;

  /**
   *
   */
  public Student() {
    super();
  }

  /**
   * @param firstName
   * @param lastName
   */
  public Student(String firstName, String lastName) {
    super();
    this.firstName = firstName;
    this.lastName = lastName;
  }

  @Override
  public String toString() {
    return "Student [firstName=" +
           firstName +
           ", lastName=" +
           lastName +
           "]";
  }

  /**
   * @return the firstName
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * @param firstName the firstName to set
   */
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  /**
   * @return the lastName
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * @param lastName the lastName to set
   */
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

}

package com.joaoiora.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.joaoiora.validation.FieldMatch;
import com.joaoiora.validation.ValidEmail;

/**
 * @author João Iora
 */
@FieldMatch.List({ @FieldMatch(first = "password",
                               second = "matchingPassword",
                               message = "The password fields must match") })
public class CrmUser {

  /**
   *
   */
  @NotNull(message = "is required")
  @Size(min = 1,
        message = "is required")
  private String userName;

  /**
   *
   */
  @NotNull(message = "is required")
  @Size(min = 1,
        message = "is required")
  private String password;

  /**
   *
   */
  @NotNull(message = "is required")
  @Size(min = 1,
        message = "is required")
  private String matchingPassword;

  /**
   *
   */
  @NotNull(message = "is required")
  @Size(min = 1,
        message = "is required")
  private String firstName;

  /**
   *
   */
  @NotNull(message = "is required")
  @Size(min = 1,
        message = "is required")
  private String lastName;

  @NotNull(message = "is required")
  @Size(min = 1,
        message = "is required")
  @ValidEmail
  private String email;

  /**
   *
   */
  public CrmUser() {
    super();
  }

  /**
   * @param userName
   * @param password
   * @param matchingPassword
   * @param firstName
   */

  public CrmUser(String userName, String password, String matchingPassword,
                 String firstName) {
    super();
    this.userName = userName;
    this.password = password;
    this.matchingPassword = matchingPassword;
    this.firstName = firstName;
  }

  /**
   * @return the userName
   */
  public String getUserName() {
    return userName;
  }

  /**
   * @param userName the userName to set
   */
  public void setUserName(String userName) {
    this.userName = userName;
  }

  /**
   * @return the password
   */
  public String getPassword() {
    return password;
  }

  /**
   * @param password the password to set
   */
  public void setPassword(String password) {
    this.password = password;
  }

  /**
   * @return the matchingPassword
   */
  public String getMatchingPassword() {
    return matchingPassword;
  }

  /**
   * @param matchingPassword the matchingPassword to set
   */
  public void setMatchingPassword(String matchingPassword) {
    this.matchingPassword = matchingPassword;
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

  /**
   * @return the email
   */
  public String getEmail() {
    return email;
  }

  /**
   * @param email the email to set
   */
  public void setEmail(String email) {
    this.email = email;
  }

}

package com.joaoiora.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * @author João Iora
 */
@Entity
@Table(name = "user")
public class User {

  /**
   *
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  /**
   *
   */
  @Column(name = "username")
  private String userName;

  /**
   *
   */
  @Column(name = "password")
  private String password;

  /**
   *
   */
  @Column(name = "first_name")
  private String firstName;

  /**
   *
   */
  @Column(name = "last_name")
  private String lastName;

  /**
   *
   */
  @Column(name = "email")
  private String email;

  /**
   *
   */
  @ManyToMany(fetch = FetchType.LAZY,
              cascade = CascadeType.ALL)
  @JoinTable(name = "users_roles",
             joinColumns = @JoinColumn(name = "user_id"),
             inverseJoinColumns = @JoinColumn(name = "role_id"))
  private List<Role> roles = new ArrayList<>();

  /**
   *
   */
  public User() {
    super();
  }

  /**
   * @param userName
   * @param password
   * @param firstName
   */
  public User(String userName, String password, String firstName) {
    super();
    this.userName = userName;
    this.password = password;
    this.firstName = firstName;
  }

  /**
   * @param userName
   * @param password
   * @param firstName
   * @param lastName
   * @param email
   */
  public User(String userName, String password, String firstName,
              String lastName, String email) {
    super();
    this.userName = userName;
    this.password = password;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
  }

  /**
   * @return the id
   */
  public Long getId() {
    return id;
  }

  /**
   * @param id the id to set
   */
  public void setId(Long id) {
    this.id = id;
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

  /**
   * @return the roles
   */
  public List<Role> getRoles() {
    return roles;
  }

  /**
   * @param roles the roles to set
   */
  public void setRoles(List<Role> roles) {
    this.roles = roles;
  }

}

package com.joaoiora.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author João Iora
 */
@Entity
@Table(name = "employee")
public class Employee {

  /**
   *
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private int id;

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
  public Employee() {
    super();
  }

  /**
   * @param id
   * @param firstName
   * @param lastName
   * @param email
   */
  public Employee(int id, String firstName, String lastName, String email) {
    this();
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
  }

  /**
   * @param firstName
   * @param lastName
   * @param email
   */
  public Employee(String firstName, String lastName, String email) {
    this();
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
  }

  @Override
  public String toString() {
    return "Employee [id=" +
           id +
           ", firstName=" +
           firstName +
           ", lastName=" +
           lastName +
           ", email=" +
           email +
           "]";
  }

  /**
   * @return the id
   */
  public int getId() {
    return id;
  }

  /**
   * @param id the id to set
   */
  public void setId(int id) {
    this.id = id;
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

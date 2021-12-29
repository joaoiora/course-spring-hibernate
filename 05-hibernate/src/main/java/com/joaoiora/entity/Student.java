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
@Table(name = "student")
public class Student {

  /**
   *
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Integer id;

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
  public Student() {
    super();
  }

  /**
   * @param fistName
   * @param lastName
   * @param email
   */
  public Student(String fistName, String lastName, String email) {
    super();
    this.firstName = fistName;
    this.lastName = lastName;
    this.email = email;
  }

  @Override
  public String toString() {
    return "Student [id=" +
           id +
           ", fistName=" +
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
  public Integer getId() {
    return id;
  }

  /**
   * @param id the id to set
   */
  public void setId(Integer id) {
    this.id = id;
  }

  /**
   * @return the fistName
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * @param fistName the fistName to set
   */
  public void setFirstName(String fistName) {
    this.firstName = fistName;
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

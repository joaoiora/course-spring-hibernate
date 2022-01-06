package com.joaoiora.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author João Iora
 */
// @JsonIgnoreProperties(value = { "address", "languages" })
@JsonIgnoreProperties(ignoreUnknown = true)
public class StudentFile {

  /**
   *
   */
  private Integer id;

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
  private Boolean active;

  /**
   *
   */
  private AddressFile address;

  /**
   *
   */
  private List<String> languages;

  /**
   *
   */
  public StudentFile() {
    super();
  }

  /**
   * @param id
   * @param firstName
   * @param lastName
   * @param active
   */
  public StudentFile(Integer id, String firstName, String lastName,
                 Boolean active) {
    super();
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.active = active;
  }

  @Override
  public String toString() {
    return "Student [id=" +
           id +
           ", firstName=" +
           firstName +
           ", lastName=" +
           lastName +
           ", active=" +
           active +
           ", address=" +
           address +
           ", languages=" +
           languages +
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
   * @return the active
   */
  public Boolean getActive() {
    return active;
  }

  /**
   * @param active the active to set
   */
  public void setActive(Boolean active) {
    this.active = active;
  }

  /**
   * @return the address
   */
  public AddressFile getAddress() {
    return address;
  }

  /**
   * @param address the address to set
   */
  public void setAddress(AddressFile address) {
    this.address = address;
  }

  /**
   * @return the languages
   */
  public List<String> getLanguages() {
    return languages;
  }

  /**
   * @param languages the languages to set
   */
  public void setLanguages(List<String> languages) {
    this.languages = languages;
  }

}

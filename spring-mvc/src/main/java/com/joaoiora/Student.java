package com.joaoiora;

import java.util.Map;

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
  private String country;

  /**
   *
   */
  private String favoriteLanguage;

  /**
   *
   */
  private String[] operatingSystems;

  /**
   *
   */
  private final Map<String, String> countries = Map.of("BR",
                                                       "Brazil",
                                                       "FR",
                                                       "France",
                                                       "DE",
                                                       "Germany",
                                                       "IN",
                                                       "India",
                                                       "US",
                                                       "United States");

  /**
   *
   */
  public Student() {
    super();

  }

  /**
   * @return the firstName
   */
  public String getFirstName() {
    return firstName;
  }

  @Override
  public String toString() {
    return "Student [firstName=" +
           firstName +
           ", lastName=" +
           lastName +
           ", country=" +
           country +
           "]";
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
   * @return the country
   */
  public String getCountry() {
    return country;
  }

  /**
   * @param country the country to set
   */
  public void setCountry(String country) {
    this.country = country;
  }

  /**
   * @return the favoriteLanguage
   */
  public String getFavoriteLanguage() {
    return favoriteLanguage;
  }

  /**
   * @param favoriteLanguage the favoriteLanguage to set
   */
  public void setFavoriteLanguage(String favoriteLanguage) {
    this.favoriteLanguage = favoriteLanguage;
  }

  /**
   * @return the operatingSystems
   */
  public String[] getOperatingSystems() {
    return operatingSystems;
  }

  /**
   * @param operatingSystems the operatingSystems to set
   */
  public void setOperatingSystems(String[] operatingSystems) {
    this.operatingSystems = operatingSystems;
  }

  /**
   * @return the countries
   */
  public Map<String, String> getCountries() {
    return countries;
  }

}

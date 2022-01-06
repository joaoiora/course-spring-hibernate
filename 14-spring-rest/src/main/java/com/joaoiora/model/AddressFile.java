package com.joaoiora.model;

/**
 * @author João Iora
 */
public class AddressFile {

  /**
   *
   */
  private String street;

  /**
   *
   */
  private String city;

  /**
   *
   */
  private String state;

  /**
   *
   */
  private String zip;

  /**
   *
   */
  private String country;

  /**
   *
   */
  public AddressFile() {
    super();
  }

  /**
   * @param street
   * @param city
   * @param state
   * @param zip
   * @param country
   */
  public AddressFile(String street, String city, String state, String zip,
                 String country) {
    super();
    this.street = street;
    this.city = city;
    this.state = state;
    this.zip = zip;
    this.country = country;
  }

  @Override
  public String toString() {
    return "Address [street=" +
           street +
           ", city=" +
           city +
           ", state=" +
           state +
           ", zip=" +
           zip +
           ", country=" +
           country +
           "]";
  }

  /**
   * @return the street
   */
  public String getStreet() {
    return street;
  }

  /**
   * @param street the street to set
   */
  public void setStreet(String street) {
    this.street = street;
  }

  /**
   * @return the city
   */
  public String getCity() {
    return city;
  }

  /**
   * @param city the city to set
   */
  public void setCity(String city) {
    this.city = city;
  }

  /**
   * @return the state
   */
  public String getState() {
    return state;
  }

  /**
   * @param state the state to set
   */
  public void setState(String state) {
    this.state = state;
  }

  /**
   * @return the zip
   */
  public String getZip() {
    return zip;
  }

  /**
   * @param zip the zip to set
   */
  public void setZip(String zip) {
    this.zip = zip;
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

}

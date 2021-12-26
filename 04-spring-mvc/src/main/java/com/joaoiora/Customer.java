package com.joaoiora;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * @author João Iora
 */
public class Customer {

  /**
   *
   */
  private String firstName;

  /**
   *
   */
  @NotNull(message = "is required")
  @Size(min = 1,
        message = "is required")
  private String lastName;

  /**
   *
   */
  @NotNull(message = "is required")
  @Min(value = 0,
       message = "must be greater than or equal to zero")
  @Max(value = 10,
       message = "must be less than or equal to 10")
  private Integer freePasses;

  /**
   *
   */
  @Pattern(regexp = "^[a-zA-Z0-9]{5}",
           message = "only 5 chars/digits")
  private String postalCode;

  /**
   *
   */
  // @CourseCode
  @CourseCode(value = "IORA",
              message = "must start with IORA")
  private String courseCode;

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
   * @return the freePasses
   */
  public Integer getFreePasses() {
    return freePasses;
  }

  /**
   * @param freePasses the freePasses to set
   */
  public void setFreePasses(Integer freePasses) {
    this.freePasses = freePasses;
  }

  /**
   * @return the postalCode
   */
  public String getPostalCode() {
    return postalCode;
  }

  /**
   * @param postalCode the postalCode to set
   */
  public void setPostalCode(String postalCode) {
    this.postalCode = postalCode;
  }

  /**
   * @return the courseCode
   */
  public String getCourseCode() {
    return courseCode;
  }

  /**
   * @param courseCode the courseCode to set
   */
  public void setCourseCode(String courseCode) {
    this.courseCode = courseCode;
  }

}

package com.joaoiora;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author João Iora
 */
public class CourseCodeConstraintValidator
  implements ConstraintValidator<CourseCode, String> {

  /**
   *
   */
  private String coursePrefix;

  @Override
  public void initialize(CourseCode courseCode) {
    this.coursePrefix = courseCode.value();
  }

  @Override
  public boolean isValid(String courseCode, ConstraintValidatorContext context) {
    if (courseCode != null) {
      return courseCode.startsWith(coursePrefix);
    }
    return true;
  }

}

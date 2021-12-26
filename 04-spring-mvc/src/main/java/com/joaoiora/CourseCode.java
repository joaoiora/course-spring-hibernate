package com.joaoiora;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * @author João Iora
 */
@Constraint(validatedBy = CourseCodeConstraintValidator.class)
@Target(value = { ElementType.METHOD, ElementType.FIELD })
@Retention(value = RetentionPolicy.RUNTIME)
public @interface CourseCode {

  /**
   * @return
   */
  String value() default "LUV";

  /**
   * @return
   */
  String message() default "must start with LUV";

  /**
   * @return
   */
  Class<?>[] groups() default {};

  /**
   * @return
   */
  Class<? extends Payload>[] payload() default {};

}

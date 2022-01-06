package com.joaoiora.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * @author João Iora
 */
@Constraint(validatedBy = EmailValidator.class)
@Target({ ElementType.TYPE, ElementType.FIELD, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ValidEmail {

  /**
   * @return
   */
  String message() default "Invalid email";

  /**
   * @return
   */
  Class<?>[] groups() default {};

  /**
   * @return
   */
  Class<? extends Payload>[] payload() default {};

}

package com.joaoiora.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;

import org.jvnet.staxex.StAxSOAPBody.Payload;

/**
 * @author João Iora
 */
@Constraint(validatedBy = FieldMatchValidator.class)
@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FieldMatch {

  /**
   * @return
   */
  String message() default "";

  /**
   * @return
   */
  Class<?>[] groups() default {};

  /**
   * @return
   */
  Class<? extends Payload>[] payload() default {};

  /**
   * @return
   */
  String first();

  /**
   * @return
   */
  String second();

  /**
   * @author João Iora
   */
  @Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
  @Retention(RetentionPolicy.RUNTIME)
  @Documented
  @interface List {

    /**
     * @return
     */
    FieldMatch[] value();

  }

}

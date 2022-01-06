package com.joaoiora.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.BeanWrapperImpl;

/**
 * @author João Iora
 */
public class FieldMatchValidator
  implements ConstraintValidator<FieldMatch, Object> {

  /**
   *
   */
  private String firstFieldName;

  /**
   *
   */
  private String secondFieldName;

  /**
   *
   */
  private String message;

  @Override
  public void initialize(final FieldMatch constraintAnnotation) {
    firstFieldName = constraintAnnotation.first();
    secondFieldName = constraintAnnotation.second();
    message = constraintAnnotation.message();
  }

  @Override
  public boolean isValid(final Object value,
                         final ConstraintValidatorContext context) {
    var valid = true;
    try {
      final var firstObj = new BeanWrapperImpl(value)
          .getPropertyValue(firstFieldName);
      final var secondObj = new BeanWrapperImpl(value)
          .getPropertyValue(secondFieldName);
      valid = ((firstObj == null) && (secondObj == null))
          || ((firstObj != null) && firstObj.equals(secondObj));
    }
    catch (@SuppressWarnings("unused") final Exception ignore) {
      // we can ignore
    }
    if (!valid) {
      context.buildConstraintViolationWithTemplate(message)
          .addPropertyNode(firstFieldName).addConstraintViolation()
          .disableDefaultConstraintViolation();
    }
    return valid;
  }

}

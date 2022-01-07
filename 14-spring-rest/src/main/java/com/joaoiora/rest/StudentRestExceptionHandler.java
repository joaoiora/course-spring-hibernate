package com.joaoiora.rest;

import javax.management.ServiceNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author João Iora
 */
@ControllerAdvice
public class StudentRestExceptionHandler {

  /**
   * @param e
   *
   * @return
   */
  @ExceptionHandler
  public ResponseEntity<StudentErrorResponse> handleException(ServiceNotFoundException e) {
    final var error = new StudentErrorResponse(HttpStatus.NOT_FOUND.value(),
        e.getMessage(), System.currentTimeMillis());
    return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
  }

  /**
   * @param e
   *
   * @return
   */
  @ExceptionHandler
  public ResponseEntity<StudentErrorResponse> handleException(Exception e) {
    final var error = new StudentErrorResponse(HttpStatus.BAD_REQUEST.value(),
        e.getMessage(), System.currentTimeMillis());
    return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
  }

}

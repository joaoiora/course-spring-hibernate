package com.joaoiora.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.joaoiora.exception.CustomerNotFoundException;

/**
 * @author João Iora
 */
@RestControllerAdvice
public class CustomerRestExceptionHandler {

  /**
   * @param e
   *
   * @return
   */
  @ExceptionHandler
  public ResponseEntity<ErrorResponse> handleException(CustomerNotFoundException e) {
    return new ResponseEntity<>(new ErrorResponse(HttpStatus.NOT_FOUND.value(),
        e.getMessage(), System.currentTimeMillis()), HttpStatus.NOT_FOUND);
  }

  /**
   * @param e
   *
   * @return
   */
  @ExceptionHandler
  public ResponseEntity<ErrorResponse> handleException(Exception e) {
    return new ResponseEntity<>(
        new ErrorResponse(HttpStatus.BAD_REQUEST.value(), e.getMessage(),
            System.currentTimeMillis()),
        HttpStatus.BAD_REQUEST);
  }

}

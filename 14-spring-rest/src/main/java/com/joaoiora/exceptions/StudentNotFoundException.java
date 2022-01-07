package com.joaoiora.exceptions;

/**
 * @author João Iora
 */
public class StudentNotFoundException
  extends RuntimeException {

  /**
   *
   */
  private static final long serialVersionUID = 1L;

  /**
   *
   */
  public StudentNotFoundException() {
    super();
  }

  /**
   * @param message
   * @param cause
   * @param enableSuppression
   * @param writableStackTrace
   */
  public StudentNotFoundException(String message, Throwable cause,
                                  boolean enableSuppression,
                                  boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }

  /**
   * @param message
   * @param cause
   */
  public StudentNotFoundException(String message, Throwable cause) {
    super(message, cause);
  }

  /**
   * @param message
   */
  public StudentNotFoundException(String message) {
    super(message);
  }

  /**
   * @param cause
   */
  public StudentNotFoundException(Throwable cause) {
    super(cause);
  }

}

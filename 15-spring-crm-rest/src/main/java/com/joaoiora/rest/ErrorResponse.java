package com.joaoiora.rest;

/**
 * @author João Iora
 */
public class ErrorResponse {

  /**
   *
   */
  private Integer status;

  /**
   *
   */
  private String message;

  /**
   *
   */
  private Long timestamp;

  /**
   * @param status
   * @param message
   * @param timestamp
   */
  public ErrorResponse(Integer status, String message, Long timestamp) {
    super();
    this.status = status;
    this.message = message;
    this.timestamp = timestamp;
  }

  @Override
  public String toString() {
    return "ErrorResponse [status=" +
           status +
           ", message=" +
           message +
           ", timestamp=" +
           timestamp +
           "]";
  }

  /**
   * @return the status
   */
  public Integer getStatus() {
    return status;
  }

  /**
   * @param status the status to set
   */
  public void setStatus(Integer status) {
    this.status = status;
  }

  /**
   * @return the message
   */
  public String getMessage() {
    return message;
  }

  /**
   * @param message the message to set
   */
  public void setMessage(String message) {
    this.message = message;
  }

  /**
   * @return the timestamp
   */
  public Long getTimestamp() {
    return timestamp;
  }

  /**
   * @param timestamp the timestamp to set
   */
  public void setTimestamp(Long timestamp) {
    this.timestamp = timestamp;
  }

}

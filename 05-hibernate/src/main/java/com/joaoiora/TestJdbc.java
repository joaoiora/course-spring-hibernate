package com.joaoiora;

import java.sql.DriverManager;

/**
 * @author João Iora
 */
public class TestJdbc {

  /**
   * @param args
   */
  public static void main(String[] args) {
    final var url = "jdbc:postgresql://localhost:5432/hb_student_tracker";
    final var user = "hbstudent";
    final var password = "hbstudent";
    try (var connection = DriverManager.getConnection(url,
                                                      user,
                                                      password)) {
      System.out.println("Successfully connected to database.");
    }
    catch (final Exception e) {
      e.printStackTrace();
    }
  }

}

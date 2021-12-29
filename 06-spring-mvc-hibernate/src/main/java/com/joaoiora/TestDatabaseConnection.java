package com.joaoiora;

import java.io.IOException;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestDatabaseConnection
 */
@WebServlet("/TestDatabaseConnection")
public class TestDatabaseConnection
  extends HttpServlet {

  /**
   *
   */
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public TestDatabaseConnection() {
    super();
  }

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    final var url = "jdbc:postgresql://localhost:5432/web_customer_tracker";
    final var user = "springstudent";
    final var password = "springstudent";
    final var driver = "org.postgresql.Driver";
    final var out = response.getWriter();
    try {
      Class.forName(driver);
      try (var connection = DriverManager.getConnection(url,
                                                        user,
                                                        password)) {

        out.println("Successfully connected to database: " +
                    url);
      }
      catch (final Exception e) {
        e.printStackTrace();
        throw new ServletException(e);
      }
    }
    catch (final ClassNotFoundException e) {
      out.println("Could not find class: " +
                  driver);
      throw new ServletException(e);
    }
    finally {
      if (out != null) {
        out.close();
      }
    }
  }

}

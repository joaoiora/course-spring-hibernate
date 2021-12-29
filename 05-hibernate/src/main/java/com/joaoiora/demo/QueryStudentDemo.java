package com.joaoiora.demo;

import org.hibernate.cfg.Configuration;

import com.joaoiora.entity.Student;

/**
 * @author João Iora
 */
public class QueryStudentDemo {

  /**
   * @param args
   */
  public static void main(String[] args) {
    try (final var factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
        .buildSessionFactory();
         var session = factory.getCurrentSession()) {
      session.beginTransaction();
      final var students = session.createQuery("from Student",
                                               Student.class)
          .getResultList();
      students.forEach(System.out::println);
      System.out.println("\n");
      final var does = session.createQuery("FROM Student s WHERE s.lastName = 'Doe'",
                                           Student.class)
          .getResultList();
      does.forEach(System.out::println);
      System.out.println("\n");

      final var doesOrBill = session.createQuery("FROM Student s WHERE s.lastName = 'Doe' OR s.firstName='Bill'",
                                                 Student.class)
          .getResultList();
      doesOrBill.forEach(System.out::println);
      System.out.println("\n");

      final var emails = session.createQuery("FROM Student s WHERE s.email LIKE '%@doe.com'",
                                             Student.class)
          .getResultList();
      emails.forEach(System.out::println);
      session.getTransaction().commit();
    }
  }

}

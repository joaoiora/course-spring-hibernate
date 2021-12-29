package com.joaoiora.demo;

import org.hibernate.cfg.Configuration;

import com.joaoiora.entity.Student;

/**
 * @author João Iora
 */
public class CreateStudentDemo {

  /**
   * @param args
   */
  public static void main(String[] args) {
    try (final var factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
        .buildSessionFactory();
         var session = factory.getCurrentSession()) {
      session.beginTransaction();
      session.save(new Student("John", "Doe", "john@doe.com"));
      session.getTransaction().commit();
    }
  }

}

package com.joaoiora.demo;

import org.hibernate.cfg.Configuration;

import com.joaoiora.entity.Student;

/**
 * @author João Iora
 */
public class CreateAndReadStudentDemo {

  /**
   * @param args
   */
  public static void main(String[] args) {
    try (final var factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
        .buildSessionFactory();
         var session = factory.getCurrentSession()) {
      session.beginTransaction();
      session.save(new Student("Bill", "Clinton", "bill@clinton.com"));
      session.save(new Student("Barack", "Obama", "barack@obama.com"));
      session.save(new Student("Bill", "Nye", "billn@nye.com"));
      session.getTransaction().commit();
    }
  }

}

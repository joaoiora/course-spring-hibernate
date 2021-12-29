package com.joaoiora.demo;

import org.hibernate.cfg.Configuration;

import com.joaoiora.entity.Student;

/**
 * @author João Iora
 */
public class PrimaryKeyDemo {

  /**
   * @param args
   */
  public static void main(String[] args) {
    try (final var factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
        .buildSessionFactory()) {
      var session = factory.getCurrentSession();
      session.beginTransaction();
      final var student = new Student("Joseph", "Climber", "joseph@climber.com");
      session.save(student);
      session.getTransaction().commit();

      System.out.println("Joseph Climber's ID: " +
                         student.getId());
      session.close();

      session = factory.getCurrentSession();
      session.beginTransaction();
      System.out.println("Retrieving Joseph Climber.");
      final var databaseStudent = session.get(Student.class,
                                              student.getId());
      if (databaseStudent != null) {
        System.out.println("Joseph Climber: " +
                           databaseStudent);
      }
      else {
        System.out.println("Couldn't find Joseph Climber.");
      }
      session.getTransaction().commit();
      session.close();
    }
  }

}

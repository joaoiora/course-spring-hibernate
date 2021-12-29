package com.joaoiora.demo.onetoone;

import org.hibernate.cfg.Configuration;

import com.joaoiora.entity.Instructor;
import com.joaoiora.entity.InstructorDetail;

/**
 * @author João Iora
 */
public class DeleteInstructorDemo {

  /**
   * @param args
   */
  public static void main(String[] args) {

    try (final var factory = new Configuration().configure("hb-mappings-hibernate.cfg.xml")
        .addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
         final var session = factory.getCurrentSession()) {
      session.beginTransaction();
      final var id = 4;
      final var instructor = session.get(Instructor.class,
                                         id);
      System.out.println("Found instructor: " +
                         instructor);
      if (instructor != null) {
        System.out.println("Deleting: " +
                           instructor);
        session.delete(instructor);
      }
      session.getTransaction().commit();
      System.out.println("Done!");
    }
  }

}

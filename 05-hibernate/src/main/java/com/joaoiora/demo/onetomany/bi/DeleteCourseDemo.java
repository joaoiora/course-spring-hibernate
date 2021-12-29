package com.joaoiora.demo.onetomany.bi;

import org.hibernate.cfg.Configuration;

import com.joaoiora.entity.Course;
import com.joaoiora.entity.Instructor;
import com.joaoiora.entity.InstructorDetail;

/**
 * @author João Iora
 */
public class DeleteCourseDemo {

  /**
   * @param args
   */
  public static void main(String[] args) {
    try (final var factory = new Configuration().configure("hb-mappings-hibernate.cfg.xml")
        .addAnnotatedClass(Course.class).addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class)
        .buildSessionFactory();
         final var session = factory.getCurrentSession()) {
      session.beginTransaction();
      final var course = session.get(Course.class,
                                     1);
      System.out.println("Deleting course: " +
                         course);
      session.delete(course);
      session.getTransaction().commit();
      System.out.println("Done!");
    }
  }

}

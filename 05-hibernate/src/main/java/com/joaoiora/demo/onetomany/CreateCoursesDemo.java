package com.joaoiora.demo.onetomany;

import org.hibernate.cfg.Configuration;

import com.joaoiora.entity.Course;
import com.joaoiora.entity.Instructor;
import com.joaoiora.entity.InstructorDetail;

/**
 * @author João Iora
 */
public class CreateCoursesDemo {

  /**
   * @param args
   */
  public static void main(String[] args) {
    try (final var factory = new Configuration().configure("hb-mappings-hibernate.cfg.xml")
        .addAnnotatedClass(Course.class).addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class)
        .buildSessionFactory();
         final var session = factory.getCurrentSession()) {
      session.beginTransaction();
      final var instructor = session.get(Instructor.class,
                                         1);
      final var course1 = new Course("Air Guitar - The Ultimate Guide");
      instructor.add(course1);
      final var course2 = new Course("The Pinball Masterclass");
      instructor.add(course2);
      session.save(course1);
      session.save(course2);
      session.getTransaction().commit();
      System.out.println("Done!");
    }
  }

}

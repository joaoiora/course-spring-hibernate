package com.joaoiora.demo.onetomany.uni;

import org.hibernate.cfg.Configuration;

import com.joaoiora.entity.Course;
import com.joaoiora.entity.Instructor;
import com.joaoiora.entity.InstructorDetail;
import com.joaoiora.entity.Review;

/**
 * @author João Iora
 */
public class DeleteCourseAndReviewsDemo {

  /**
   * @param args
   */
  public static void main(String[] args) {
    try (final var factory = new Configuration().configure("hb-mappings-hibernate.cfg.xml")
        .addAnnotatedClass(Course.class).addAnnotatedClass(Review.class).addAnnotatedClass(Instructor.class)
        .addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
         final var session = factory.getCurrentSession()) {
      session.beginTransaction();
      final var course = session.get(Course.class,
                                     9);
      System.out.println("Deleting the course ... ");
      System.out.println(course);
      System.out.println(course.getReviews());
      session.delete(course);
      session.getTransaction().commit();
      System.out.println("Done!");
    }
  }

}

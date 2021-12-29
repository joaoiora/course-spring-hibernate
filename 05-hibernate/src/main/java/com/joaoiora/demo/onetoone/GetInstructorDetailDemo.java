package com.joaoiora.demo.onetoone;

import org.hibernate.cfg.Configuration;

import com.joaoiora.entity.Instructor;
import com.joaoiora.entity.InstructorDetail;

/**
 * @author João Iora
 */
public class GetInstructorDetailDemo {

  /**
   * @param args
   */
  public static void main(String[] args) {

    try (final var factory = new Configuration().configure("01-one-to-one-uni-hibernate.cfg.xml")
        .addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
         final var session = factory.getCurrentSession()) {
      session.beginTransaction();
      final var id = 2999;
      final var instructorDetail = session.get(InstructorDetail.class,
                                               id);
      System.out.println("instructorDetail: " +
                         instructorDetail);
      System.out.println("the associated instructor: " +
                         instructorDetail.getInstructor());
      session.getTransaction().commit();
      System.out.println("Done!");
    }
    catch (final Exception exc) {
      exc.printStackTrace();
    }
  }

}

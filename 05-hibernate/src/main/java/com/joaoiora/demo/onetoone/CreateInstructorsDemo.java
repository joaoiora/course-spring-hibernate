package com.joaoiora.demo.onetoone;

import org.hibernate.cfg.Configuration;

import com.joaoiora.entity.Instructor;
import com.joaoiora.entity.InstructorDetail;

/**
 * @author João Iora
 */
public class CreateInstructorsDemo {

  /**
   * @param args
   */
  public static void main(String[] args) {

    try (final var factory = new Configuration().configure("01-one-to-one-uni-hibernate.cfg.xml")
        .addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
         final var session = factory.getCurrentSession()) {

      final var chad = new Instructor("Chad", "Darby", "darby@luv2code.com");
      final var chadDetail = new InstructorDetail("http://www.luv2code.com/youtube", "Luv 2 code!!!");
      chad.setInstructorDetail(chadDetail);

      final var madhu = new Instructor("Madhu", "Patel", "madhu@luv2code.com");
      final var madhuDetail = new InstructorDetail("http://www.youtube.com", "Guitar");
      madhu.setInstructorDetail(madhuDetail);

      session.beginTransaction();
      System.out.println("Saving instructor: " +
                         chad);
      session.save(chad);

      System.out.println("Saving instructor: " +
                         madhu);
      session.save(madhu);

      session.getTransaction().commit();
      System.out.println("Done!");
    }
  }

}

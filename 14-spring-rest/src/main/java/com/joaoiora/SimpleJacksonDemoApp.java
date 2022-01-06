package com.joaoiora;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.joaoiora.model.StudentFile;

/**
 * @author João Iora
 */
public class SimpleJacksonDemoApp {

  /**
   * @param args
   */
  public static void main(String[] args) {
    final var mapper = new ObjectMapper();
    try (var file = SimpleJacksonDemoApp.class
        .getResourceAsStream("/sample-full.json")) {
      final var student = mapper.readValue(file,
                                           StudentFile.class);
      System.out.println(student);
    }
    catch (final IOException e) {
      e.printStackTrace();
    }
  }

}

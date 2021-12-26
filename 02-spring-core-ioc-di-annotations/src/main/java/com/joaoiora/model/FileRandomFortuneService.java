package com.joaoiora.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

/**
 * @author João Iora
 */
@Component
public class FileRandomFortuneService
  implements FortuneService {

  /**
   *
   */
  private static final String FILE = "src/main/resources/fortunes.txt";

  /**
   *
   */
  private List<String> fortunes;

  /**
   *
   */
  public FileRandomFortuneService() {

  }

  /**
   *
   */
  @PostConstruct
  private void init() {
    System.out.println(">> FileRandomFortuneService: inside init() method");
    fortunes = new ArrayList<>();
    try (var reader = new BufferedReader(new FileReader(FILE))) {
      var line = "";
      while ((line = reader.readLine()) != null) {
        fortunes.add(line);
      }
    }
    catch (final IOException e) {
      e.printStackTrace();
    }
    System.out.println(">> Amount of Fortunes: " +
                       fortunes.size());
  }

  @Override
  public String getFortune() {
    return fortunes.get(new Random().nextInt(fortunes.size()));
  }

  /**
   *
   */
  @PreDestroy
  public void cleanup() {
    System.out.println(">> FileRandomFortuneService: Inside cleanup() method, setting fortunes to null.");
    fortunes = null;
    System.out.println(">> FileRandomFortuneService: fortunes = " +
                       fortunes);
  }

}

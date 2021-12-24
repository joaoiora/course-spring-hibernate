package com.joaoiora.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
  private final List<String> fortunes = new ArrayList<>();

  /**
   *
   */
  public FileRandomFortuneService() {
    readFortunes();
  }

  /**
   *
   */
  private void readFortunes() {
    try (var reader = new BufferedReader(new FileReader(FILE))) {
      var line = "";
      while ((line = reader.readLine()) != null) {
        fortunes.add(line);
      }
    }
    catch (final IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  public String getFortune() {
    return fortunes.get(new Random().nextInt(fortunes.size()));
  }

}

package com.huex.assignments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

/**
 * Entry point of application
 */
@SpringBootApplication
public class CLIParameters implements CommandLineRunner {

  private static final String CSV_FILE_PATH = "events.csv";

  @Autowired
  private CsvReader csvReader;

  public static void main(String[] args) {
    SpringApplication.run(CLIParameters.class, args);
  }
  @Override
  public void run(String... args) throws Exception {
    csvReader.readCsvDataFromCSV(CSV_FILE_PATH);
  }
}

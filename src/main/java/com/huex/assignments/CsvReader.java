package com.huex.assignments;

import org.jline.utils.Log;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Utility class for CSV data manipulation.
 */
@Service
public class CsvReader {
  
  public List<CSVModel> readCsvDataFromCSV(String csvFilePath) {
    Log.info("Inside readCsvDataFromCSV ");
    Log.debug("Reading CSV data from file located at "+csvFilePath);
    List<CSVModel> list = new ArrayList<>();
    Path pathToFile = Paths.get(csvFilePath);
    try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) {
      String line = br.readLine();
      while (line != null) {
        String[] attributes = line.split("\\t");
        CSVModel csvModel = createCSVObj(attributes);
        list.add(csvModel);
        line = br.readLine();
      }
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }
    return list;
  }

  /**
   * This method will map csv data to pojo attributes
   * @param attributes
   * @return model object
   */
  private CSVModel createCSVObj(String[] attributes) {
    Log.info("Inside createCSVObj method");
    Log.debug("Mapping CSV column data to respective attributes");
    String uuid = attributes[0];
    String tstamp = attributes[1];
    String source = attributes[2];
    String date = attributes[3];
    String event_type = attributes[4];
    String event_category = attributes[5];
    String event_action = attributes[6];
    String event_label = attributes[7];
    Long event_value = Long.parseLong(attributes[8]);
    String created_at = attributes[9];
    String last_updated_at = attributes[10];
    String location = attributes[11];
    return new CSVModel(uuid, tstamp, source, date, event_type, event_category,
      event_action, event_label, event_value, created_at, last_updated_at, location);
  }
}

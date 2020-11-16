package com.huex.assignments;

import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.jline.utils.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;


/**
 * Utility class for CSV data manipulation.
 */
@Service
public class CsvReader {

  @Autowired
  private Repository repository;

  public void readCsvDataFromCSV(String csvFilePath) {
    Log.info("Inside readCsvDataFromCSV ");
    Log.debug("Reading CSV data from file located at "+csvFilePath);
    try {
      Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));
      ColumnPositionMappingStrategy strategy = new ColumnPositionMappingStrategy();
      strategy.setType(CSVModel.class);
      String[] columns = new String[]{"uuid", "tstamp", "source", "date", "event_type", "event_category",
        "event_action", "event_label", "event_value", "created_at", "last_updated_at", "location"};
      strategy.setColumnMapping(columns);
      CsvToBean<CSVModel> csvToBean = new CsvToBeanBuilder(reader).withMappingStrategy(strategy)
        .withSkipLines(1).build();
      Iterator<CSVModel> iterator = csvToBean.iterator();
      while (iterator.hasNext()) {
        CSVModel csvModel = iterator.next();
        repository.save(csvModel);
      }
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }
  }
}


import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 * Driver class for CLI
 */
public class CLIParameters {
  private static final String CSV_FILE_PATH = "src/main/resources/events.csv";
  public static void main(String[] args) {
      List<CSVModel> csvList = readCsvDataFromCSV(CSV_FILE_PATH);
      for (CSVModel csvModel:csvList) {
        //To do : Save model data
        System.out.println(csvModel);
      }
  }

  /**
   * This methos parse the csv data
   * @param fileName
   * @return
   */
  private static List<CSVModel> readCsvDataFromCSV(String fileName) {
    List<CSVModel> list = new ArrayList<>();
    Path pathToFile = Paths.get(fileName);
    try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) {
      String line = br.readLine();
      while (line != null) {
        String[] attributes = line.split(",");
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
   * This method will map csv data
   * @param attributes
   * @return
   */
  private static CSVModel createCSVObj(String[] attributes) {
    String uuid = attributes[0];
    String tstamp = attributes[1];
    String source = attributes[2];
    String date = attributes[3];
    String event_type = attributes[4];
    String event_category = attributes[5];
    String event_action = attributes[6];
    String event_label = attributes[7];
    Long event_value = Long.parseLong(attributes[8]);
    LocalDateTime created_at = LocalDateTime.parse(attributes[9]);
    LocalDateTime last_updated_at = LocalDateTime.parse(attributes[10]);
    String location = attributes[11];
    return new CSVModel(uuid, tstamp, source, date, event_type, event_category,
      event_action, event_label, event_value, created_at, last_updated_at, location);
  }
}

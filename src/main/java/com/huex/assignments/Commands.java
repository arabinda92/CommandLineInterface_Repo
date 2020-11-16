package com.huex.assignments;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import org.springframework.web.reactive.function.client.WebClient;
import java.util.List;

/**
 * This class contains all the CLI commands
 */
@ShellComponent
public class Commands {
  @ShellMethod("Displays n most viewed pages from CSV data ")
  public List<CSVModel> displayMostViewedPages(@ShellOption({"-N", "--n"}) Long n,
                                               @ShellOption({"-N", "--orderBy"})
                                                 String orderBy) {
    WebClient.Builder webclient = WebClient.builder();
    List<CSVModel> responseList = webclient.build().get()
      .uri("http://localhost:8080/Reports/viewedPages/?orderBy="+orderBy+"&count="+n)
      .retrieve().bodyToMono(List.class).block();
      return responseList;
  }

  @ShellMethod("Displays n most timespent pages from CSV data")
  public List<CSVModel> displayMostTimeSpentPages(@ShellOption({"-N", "--n"}) Long n,
                                                  @ShellOption({"-N", "--orderBy"})
                                                 String orderBy) {
    WebClient.Builder webclient = WebClient.builder();
    List<CSVModel> responseList = webclient.build().get()
      .uri("http://localhost:8080/Reports/pages/?orderBy="+orderBy+"&count="+n)
      .retrieve().bodyToMono(List.class).block();
    return responseList;
  }

  @ShellMethod("Displays n most viewed pages with date filters as optional values")
  public List<CSVModel> displayActiveUsers(@ShellOption({"-N", "--n"}) Long n,
                                           @ShellOption({"-N", "--orderBy"})
                                                    String orderBy) {
    WebClient.Builder clearwebclient = WebClient.builder();
    List<CSVModel> responseList = clearwebclient.build().get()
      .uri("http://localhost:8080/Reports/users/?orderBy="+orderBy+"&count="+n)
      .retrieve().bodyToMono(List.class).block();
    return responseList;
  }

  @ShellMethod("Displays periodic reports as per the date filters ")
  public List<CSVModel> displayTimelyReports(@ShellOption({"-N", "--n"}) Long n,
                                             @ShellOption({"-N", "--orderBy"}) String orderBy,
                                             @ShellOption({"-N", "--fromDate"}) String fromDate,
                                             @ShellOption({"-N", "--toDate"}) String toDate) {
    WebClient.Builder webclient = WebClient.builder();
    List<CSVModel> responseList = webclient.build().get()
      .uri("http://localhost:8080/Reports/users/?orderBy="+orderBy+"&count="
        +n+"&fromDate="+fromDate+"&toDate="+toDate)
      .retrieve().bodyToMono(List.class).block();
    return responseList;
  }
}

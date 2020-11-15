package com.huex.assignments;

import com.sun.net.httpserver.Headers;
import org.springframework.boot.autoconfigure.web.reactive.function.client.WebClientAutoConfiguration;
import org.springframework.http.HttpEntity;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import picocli.CommandLine;

import java.net.URI;
import java.net.URISyntaxException;
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
      .uri("http://localhost:8080/api/v1/Reports/viewedPages/?orderBy=views&count="+n)
      .retrieve().bodyToMono(List.class).block();
      return responseList;
  }

  @ShellMethod("Displays n most timespent pages from CSV data")
  public List<CSVModel> displayMostTimeSpentPages(@ShellOption({"-N", "--n"}) Long n,
                                                  @ShellOption({"-N", "--orderBy"})
                                                 String orderBy) {
    WebClient.Builder webclient = WebClient.builder();
    List<CSVModel> responseList = webclient.build().get()
      .uri("http://localhost:8080/api/v1/Reports/pages/?orderBy=timeSpent&count="+n)
      .retrieve().bodyToMono(List.class).block();
    return responseList;
  }

  @ShellMethod("Displays n most viewed pages with date filters as optional values")
  public List<CSVModel> displayActiveUsers(@ShellOption({"-N", "--n"}) Long n,
                                                  @ShellOption({"-N", "--orderBy"})
                                                    String orderBy) {
    WebClient.Builder webclient = WebClient.builder();
    List<CSVModel> responseList = webclient.build().get()
      .uri("http://localhost:8080/api/v1/Reports/pages/?orderBy=timeSpent&count="+n)
      .retrieve().bodyToMono(List.class).block();
    return responseList;
  }

}

package com.github.rubencepeda.stackoverflowcli.search;

import com.github.rubencepeda.stackoverflowcli.api.ApiResponse;
import com.github.rubencepeda.stackoverflowcli.api.Question;
import com.github.rubencepeda.stackoverflowcli.api.StackOverflowHttpClient;

import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

@Command(name = "search", description = "Searches questions matching criteria.", mixinStandardHelpOptions = true)
public class SearchCommand implements Runnable {

  @Option(names = {"-q", "--query"}, description = "Query to search for.")
  private String query = "";

  @Option(names = {"-t", "--tag"}, description = "Tag to search for.")
  private String tag = "";

  @Option(names = {"-n", "--limit"}, description = "Limit of results to return. Default is 10.")
  private int limit = 10;

  @Option(names = {"-s", "--sort"}, description = "Sort order. Default is relevance.")
  private String sort = "relevance";

  @Option(names = {"-v", "--verbose"}, description = "Verbose output.")
  private boolean verbose;


  private final StackOverflowHttpClient stackOverflowHttpClient;

  public SearchCommand(StackOverflowHttpClient stackOverflowHttpClient) {
    this.stackOverflowHttpClient = stackOverflowHttpClient;
  }

  @Override
  public void run() {
    final ApiResponse<Question> response = stackOverflowHttpClient.search(query, tag, limit, sort);

    response.items().forEach(System.out::println);
  }

}

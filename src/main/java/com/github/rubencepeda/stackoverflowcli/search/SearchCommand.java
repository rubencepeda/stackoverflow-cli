package com.github.rubencepeda.stackoverflowcli.search;

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

  @Override
  public void run() {
    System.out.println("Search command running...");
  }

}

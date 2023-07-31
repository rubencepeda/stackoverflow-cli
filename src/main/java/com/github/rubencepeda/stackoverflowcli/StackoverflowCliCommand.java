package com.github.rubencepeda.stackoverflowcli;

import com.github.rubencepeda.stackoverflowcli.search.SearchCommand;

import io.micronaut.configuration.picocli.PicocliRunner;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

@Command(name = "stackoverflow-cli", description = "Stackoverflow CLI",
    mixinStandardHelpOptions = true, subcommands = {SearchCommand.class})
public class StackoverflowCliCommand implements Runnable {

  @Option(names = {"-v", "--verbose"}, description = "...")
  boolean verbose;

  public static void main(String[] args) throws Exception {
    PicocliRunner.run(StackoverflowCliCommand.class, args);
  }

  public void run() {
    // business logic here
    if (verbose) {
      System.out.println("Hi!");
    }
  }
}

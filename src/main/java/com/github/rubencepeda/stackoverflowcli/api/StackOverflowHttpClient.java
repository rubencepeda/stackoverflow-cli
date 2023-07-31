package com.github.rubencepeda.stackoverflowcli.api;

import static io.micronaut.http.HttpHeaders.USER_AGENT;

import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Header;
import io.micronaut.http.annotation.QueryValue;
import io.micronaut.http.client.annotation.Client;

@Client(id = "stackoverflow", path = "${stackoverflow.api.url}")
@Header(name = USER_AGENT, value = "Micronaut HTTP Client")
public interface StackOverflowHttpClient {

  @Get("/search?site=stackoverflow")
  ApiResponse<Question> search(
      @QueryValue("intitle") String query,
      @QueryValue("tagged") String tag,
      @QueryValue("pagesize") int limit,
      @QueryValue("sort") String sort);
}

//# https://api.stackexchange.com/docs/search#order=desc&sort=activity&tagged=java&filter=default&site=stackoverflow

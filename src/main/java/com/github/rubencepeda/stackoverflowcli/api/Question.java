package com.github.rubencepeda.stackoverflowcli.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Question(String title,
                       String link,
                       int score,
                       @JsonProperty("answer_count") int answers,
                       @JsonProperty("is_answered") boolean accepted) {

}

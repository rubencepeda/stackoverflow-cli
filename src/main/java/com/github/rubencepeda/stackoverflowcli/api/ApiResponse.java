package com.github.rubencepeda.stackoverflowcli.api;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record ApiResponse<T>(
    List<T> items, @JsonProperty("has_more") boolean hasMore,
    @JsonProperty("quota_max") int quotaMax,
    @JsonProperty("quota_remaining") int quotaRemaining) {

}
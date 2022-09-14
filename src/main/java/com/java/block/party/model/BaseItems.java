package com.java.block.party.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
class BaseItems {

    @JsonProperty("messages")
    private Messages messages;

    @JsonProperty("results")
    private Results results;

    @JsonProperty("index")
    private List<Index> index;

}

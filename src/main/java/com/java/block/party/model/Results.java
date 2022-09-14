package com.java.block.party.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Results {

    @JsonProperty("count")
    private int count;

    @JsonProperty("items_per_page")
    private int itemsPerPage;

}
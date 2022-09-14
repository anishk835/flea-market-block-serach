package com.java.block.party.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AllItems extends BaseItems {

    @JsonProperty("item")
    private List<Item> item;

}

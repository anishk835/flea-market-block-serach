package com.java.block.party.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemDetails extends BaseItems {

    @JsonProperty("item")
    private Item item;

}

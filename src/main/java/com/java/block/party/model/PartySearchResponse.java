package com.java.block.party.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PartySearchResponse {

    private Results results;
    private List<Index> items;
    private SortOrder sortOrder;
    private Index index;
    private Item item;

}

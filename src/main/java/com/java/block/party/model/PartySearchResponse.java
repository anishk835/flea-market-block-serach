package com.java.block.party.model;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PartySearchResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    private transient Results results;
    private transient List<Index> items;
    private transient SortOrder sortOrder;
    private transient Item item;

}

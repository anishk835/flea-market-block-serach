package com.java.block.party.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class QueryParams {

    private String searchKeyWord = "";
    private String district = "";
    private int resultPerPage = 10;
    private SortOrder sortOrder;

}

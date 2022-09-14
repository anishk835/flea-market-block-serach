package com.java.block.party.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class SortOrder {

    private String type = "";
    private Order order;

}

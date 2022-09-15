package com.java.block.party.model.geo;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
class Type {

    @JsonProperty("type")
    private String type;
}

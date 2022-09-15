package com.java.block.party.model.geo;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Features extends Type {

    @JsonProperty("geometry")
    private Geometry geometry;

    @JsonProperty("properties")
    private Properties properties;
}

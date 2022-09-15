package com.java.block.party.model.geo;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemsGeoLocation extends Type {

    @JsonProperty("features")
    private Features[] features;
}

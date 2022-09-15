package com.java.block.party.model.geo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.java.block.party.model.Item;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Data extends Item {

    @JsonProperty("bezirk")
    private String bezirk;

    @JsonProperty("_wgs84_lat")
    private String latitude;

    @JsonProperty("_wgs84_lon")
    private String longitude;

}

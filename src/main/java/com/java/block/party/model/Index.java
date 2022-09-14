package com.java.block.party.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Index extends Item {

    @JsonProperty("bezirk")
    private String bezirk;

    @JsonProperty("rss_titel")
    private String title;

}

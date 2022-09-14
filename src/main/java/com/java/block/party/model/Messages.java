package com.java.block.party.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Messages {

    @JsonProperty("messages")
    private List<Messages> msg;

    @JsonProperty("success")
    private String success;

}

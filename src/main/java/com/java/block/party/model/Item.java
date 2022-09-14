package com.java.block.party.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Item {

    @JsonProperty("id")
    private String id;

    @JsonProperty("bild")
    private String bild;

    @JsonProperty("copyright")
    private String copyRight;

    @JsonProperty("bezeichnung")
    private String bezeichnung;

    @JsonProperty("strasse")
    private String strasse;

    @JsonProperty("plz")
    private String plz;

    @JsonProperty("tage")
    private String tage;

    @JsonProperty("zeiten")
    private String zeiten;

    @JsonProperty("betreiber")
    private String betreiber;

    @JsonProperty("email")
    private String email;

    @JsonProperty("www")
    private String webPage;

    @JsonProperty("bemerkungen")
    private String bemerkungen;

}

package com.java.block.party.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.java.block.party.config.Property.DefaultProperty;

@Component
public class UrlBuilder {

    private static final String ITEM_ID = "{itemId}";

    @Autowired
    private Property property;

    public String getAllItemsJsonUrl() {
        StringBuilder sb = new StringBuilder();
        DefaultProperty defaultProperty = property.getDefaultProperty();
        sb.append(defaultProperty.getBaseUrl());
        sb.append(defaultProperty.getItemsSuffix());
        sb.append(defaultProperty.getJson());
        sb.append(defaultProperty.getQueryString());
        return sb.toString();
    }

    public String getItemJsonUrl() {
        StringBuilder sb = new StringBuilder();
        DefaultProperty defaultProperty = property.getDefaultProperty();
        sb.append(defaultProperty.getBaseUrl());
        sb.append(defaultProperty.getItemSuffix());
        sb.append(ITEM_ID);
        sb.append(defaultProperty.getJson());
        return sb.toString();
    }

    public String getItemsGeoJsonUrl() {
        StringBuilder sb = new StringBuilder();
        DefaultProperty defaultProperty = property.getDefaultProperty();
        sb.append(defaultProperty.getBaseUrl());
        sb.append(defaultProperty.getItemsSuffix());
        sb.append(defaultProperty.getGeojson());
        sb.append(defaultProperty.getQueryString());
        return sb.toString();
    }

}

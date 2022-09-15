package com.java.block.party.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "party")
public class Property {

    private DefaultProperty defaultProperty = new DefaultProperty();

    public static class DefaultProperty {

        private String baseurl;
        private String itemssuffix;
        private String itemsuffix;
        private String querystring;
        private String json;
        private String geojson;

        public String getBaseUrl() {
            return baseurl;
        }

        public void setBaseUrl(String baseUrl) {
            this.baseurl = baseUrl;
        }

        public String getItemsSuffix() {
            return itemssuffix;
        }

        public void setItemsSuffix(String itemssuffix) {
            this.itemssuffix = itemssuffix;
        }

        public String getItemSuffix() {
            return itemsuffix;
        }

        public void setItemSuffix(String itemsuffix) {
            this.itemsuffix = itemsuffix;
        }

        public String getQueryString() {
            return querystring;
        }

        public void setQueryString(String querystring) {
            this.querystring = querystring;
        }

        public String getJson() {
            return json;
        }

        public void setJson(String json) {
            this.json = json;
        }

        public String getGeojson() {
            return geojson;
        }

        public void setGeojson(String geojson) {
            this.geojson = geojson;
        }

    }

    public DefaultProperty getDefaultProperty() {
        return defaultProperty;
    }
}

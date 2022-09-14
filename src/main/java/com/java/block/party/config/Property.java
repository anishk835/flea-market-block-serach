package com.java.block.party.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ConfigurationProperties(prefix = "party")
public class Property {

    private DefaultProperty defaultProperty = new DefaultProperty();

    public static class DefaultProperty {

        private String baseurl;
        private String itemssuffix;
        private String itemsuffix;
        private String querystring;
        private String format;

        public String getBaseUrl() {
            return baseurl;
        }

        public void setBaseUrl(String baseUrl) {
            log.info("base url is : {}", baseUrl);
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

        public String getFormat() {
            return format;
        }

        public void setFormat(String format) {
            this.format = format;
        }

    }

    public DefaultProperty getDefaultProperty() {
        return defaultProperty;
    }
}

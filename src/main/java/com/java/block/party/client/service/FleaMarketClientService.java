package com.java.block.party.client.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;

import com.java.block.party.config.UrlBuilder;
import com.java.block.party.model.AllItems;
import com.java.block.party.model.ItemDetails;
import com.java.block.party.model.QueryParams;
import com.java.block.party.model.SortOrder;
import com.java.block.party.model.geo.ItemsGeoLocation;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class FleaMarketClientService {

    @Autowired
    private WebClient webClient;

    @Autowired
    private UrlBuilder urlBuilder;

    public Mono<ItemsGeoLocation> getFleaMarketItemsGeoLocation(final QueryParams params) {
        String url = UriComponentsBuilder.fromUriString(urlBuilder.getItemsGeoJsonUrl()).query(buildQueryString(params))
                .build().toUriString();
        log.debug("geo based items details url is : {}", url);
        return webClient.get().uri(url).retrieve().bodyToMono(ItemsGeoLocation.class);
    }

    public Mono<AllItems> getBlockParties(final QueryParams params) {
        String url = UriComponentsBuilder.fromUriString(urlBuilder.getAllItemsJsonUrl()).query(buildQueryString(params))
                .build().toUriString();
        log.debug("items url with query string is : {}", url);
        return webClient.get().uri(url).retrieve().bodyToMono(AllItems.class);
    }

    public Mono<ItemDetails> getBlockPartyDetails(final String id) {
        String url = UriComponentsBuilder.fromUriString(urlBuilder.getItemJsonUrl()).buildAndExpand(id).toUriString();
        log.debug("item details url is : {}", url);
        return webClient.get().uri(url).retrieve().bodyToMono(ItemDetails.class);
    }

    private String buildQueryString(QueryParams params) {
        if (null == params) {
            return "";
        }
        StringBuilder queryString = new StringBuilder();
        SortOrder sortOrder = params.getSortOrder();
        queryString.append(params.getSearchKeyWord()).append("&bezirk=").append(params.getDistrict()).append("&ipp=")
                .append(params.getResultPerPage());
        if (sortOrder != null) {
            queryString.append("&order=").append(sortOrder.getType()).append("+").append(sortOrder.getOrder())
                    .append("#results");
        } else {
            queryString.append("#searchresults");
        }
        return queryString.toString();
    }
}

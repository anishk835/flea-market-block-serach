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

import reactor.core.publisher.Mono;

@Service
public class FleaMarketClientService {

    @Autowired
    private WebClient webClient;

    @Autowired
    private UrlBuilder urlBuilder;

    public Mono<AllItems> getBlockParties(final QueryParams params) {
        String url = UriComponentsBuilder.fromUriString(urlBuilder.getAllItems()).query(buildQueryString(params))
                .build().toUriString();
        return webClient.get().uri(url).retrieve().bodyToMono(AllItems.class);
    }

    public Mono<ItemDetails> getBlockPartyDetails(final String id) {
        String url = UriComponentsBuilder.fromUriString(urlBuilder.getItem()).buildAndExpand(id).toUriString();
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

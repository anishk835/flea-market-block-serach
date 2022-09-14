package com.java.block.party.template.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.java.block.party.config.UrlBuilder;
import com.java.block.party.model.AllItems;
import com.java.block.party.model.ItemDetails;
import com.java.block.party.model.QueryParams;
import com.java.block.party.model.SortOrder;

@Service
public class FleaMarketRestService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UrlBuilder urlBuilder;

    public AllItems getBlockParties(final QueryParams params) {
        String url = UriComponentsBuilder.fromUriString(urlBuilder.getAllItems()).query(buildQueryParam(params)).build()
                .toString();
        ResponseEntity<AllItems> response = restTemplate.getForEntity(url, AllItems.class);
        return response.getBody();
    }

    public ItemDetails getBlockPartyDetails(final String id) {
        String url = UriComponentsBuilder.fromUriString(urlBuilder.getItem()).buildAndExpand(id).toUriString();
        ResponseEntity<ItemDetails> response = restTemplate.getForEntity(url, ItemDetails.class);
        return response.getBody();
    }

    private String buildQueryParam(QueryParams params) {
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

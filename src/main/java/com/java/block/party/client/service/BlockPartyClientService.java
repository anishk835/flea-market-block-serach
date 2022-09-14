package com.java.block.party.client.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.block.party.model.AllItems;
import com.java.block.party.model.ItemDetails;
import com.java.block.party.model.QueryParams;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class BlockPartyClientService {

    @Autowired
    private FleaMarketClientService fleaMarketClientService;

    public Mono<ItemDetails> getBlockPartyDetails(String id) {
        log.info("party details for the given id : {}", id);
        return fleaMarketClientService.getBlockPartyDetails(id);
    }

    public Mono<AllItems> getBlockParties(QueryParams partySearchRequest) {
        log.info("search query is : {}", partySearchRequest);
        return fleaMarketClientService.getBlockParties(partySearchRequest);
    }

}

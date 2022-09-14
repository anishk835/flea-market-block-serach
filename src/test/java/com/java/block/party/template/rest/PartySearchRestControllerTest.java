package com.java.block.party.template.rest;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.java.block.party.model.PartySearchResponse;
import com.java.block.party.model.QueryParams;
import com.java.block.party.model.SortOrder;
import com.java.block.party.template.exception.BlockPartySearchException;
import com.java.block.party.template.service.PartySearchService;

@ExtendWith(MockitoExtension.class)
class PartySearchRestControllerTest {

    @InjectMocks
    private PartySearchRestController partySearchRestController;

    @Mock
    private PartySearchService mockPartySearchService;
    @Mock
    private PartySearchResponse mockPartySearchResponse;
    @Mock
    private QueryParams mockQueryParams;

    @Test
    final void testGetBlockParties() {
        when(mockPartySearchService.getBlockParties(any(QueryParams.class))).thenReturn(mockPartySearchResponse);
        partySearchRestController.getBlockParties(mockQueryParams);
        verify(mockPartySearchService, times(1)).getBlockParties(mockQueryParams);
    }

    @Test
    final void testGetBlockPartiesWithNullOrderThenThrowBlockPartySearchException() {
        SortOrder sortOrder = new SortOrder();
        sortOrder.setOrder(null);
        when(mockQueryParams.getSortOrder()).thenReturn(sortOrder);
        lenient().when(mockPartySearchService.getBlockParties(any(QueryParams.class)))
                .thenReturn(mockPartySearchResponse);
        assertThatExceptionOfType(BlockPartySearchException.class).isThrownBy(() -> {
            partySearchRestController.getBlockParties(mockQueryParams);
        }).withMessage("sort order does not contain proper details.");
        verify(mockPartySearchService, times(0)).getBlockPartyDetails(anyString());
    }

    @Test
    final void testGetBlockPartyDetails() {
        when(mockPartySearchService.getBlockPartyDetails(anyString())).thenReturn(mockPartySearchResponse);
        partySearchRestController.getBlockPartyDetails(anyString());
        verify(mockPartySearchService, times(1)).getBlockPartyDetails(anyString());
    }

}

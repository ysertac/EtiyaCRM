package com.etiya.catalogservice.services.dtos.responses.campaignProductOfferResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeletedCampaignProductOfferResponse {
    private String id;
    private String campaignId;
    private String productOfferId;
}

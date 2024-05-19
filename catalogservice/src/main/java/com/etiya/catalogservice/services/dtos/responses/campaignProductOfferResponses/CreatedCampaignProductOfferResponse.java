package com.etiya.catalogservice.services.dtos.responses.campaignProductOfferResponses;

import com.etiya.catalogservice.entities.Campaign;
import com.etiya.catalogservice.entities.ProductOffer;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatedCampaignProductOfferResponse {
    private String id;
    private String campaignId;
    private String productOfferId;
}

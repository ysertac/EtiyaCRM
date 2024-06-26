package com.etiya.catalogservice.services.dtos.responses.catalogProductOfferResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeletedCatalogProductOfferResponse {
    private String id;
    private String catalogId;
    private String productOfferId;
}

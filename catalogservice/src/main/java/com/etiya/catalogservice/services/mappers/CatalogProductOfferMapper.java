package com.etiya.catalogservice.services.mappers;

import com.etiya.catalogservice.entities.CatalogProductOffer;
import com.etiya.catalogservice.services.dtos.requests.catalogProductOfferRequests.CreateCatalogProductOfferRequest;
import com.etiya.catalogservice.services.dtos.responses.catalogProductOfferResponses.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CatalogProductOfferMapper {
    CatalogProductOfferMapper INSTANCE = Mappers.getMapper(CatalogProductOfferMapper.class);

    @Mapping(source = "catalogProductOffer.catalog.id", target = "catalogId")
    @Mapping(source = "catalogProductOffer.productOffer.id", target = "productOfferId")
    GetAllCatalogProductOfferResponse getAllCatalogProductOfferResponseFromCatalogProductOffer(CatalogProductOffer catalogProductOffer);
    @Mapping(source = "catalogProductOffer.catalog.id", target = "catalogId")
    @Mapping(source = "catalogProductOffer.productOffer.id", target = "productOfferId")
    GetCatalogProductOfferResponse getCatalogProductOfferResponseFromCatalogProductOffer(CatalogProductOffer catalogProductOffer);
    @Mapping(source = "createCatalogProductOfferRequest.catalogId", target = "catalog.id")
    @Mapping(source = "createCatalogProductOfferRequest.productOfferId", target = "productOffer.id")
    CatalogProductOffer catalogProductOfferFromCreateCatalogProductOfferRequest(CreateCatalogProductOfferRequest createCatalogProductOfferRequest);
    @Mapping(source = "catalogProductOffer.catalog.id", target = "catalogId")
    @Mapping(source = "catalogProductOffer.productOffer.id", target = "productOfferId")
    CreatedCatalogProductOfferResponse createdCatalogProductOfferResponseFromCatalogProductOffer(CatalogProductOffer catalogProductOffer);
    @Mapping(source = "catalogProductOffer.catalog.id", target = "catalogId")
    @Mapping(source = "catalogProductOffer.productOffer.id", target = "productOfferId")
    DeletedCatalogProductOfferResponse deletedCatalogProductOfferResponseFromCatalogProductOffer(CatalogProductOffer catalogProductOffer);
}

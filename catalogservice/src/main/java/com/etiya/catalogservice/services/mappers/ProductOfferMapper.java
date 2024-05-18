package com.etiya.catalogservice.services.mappers;

import com.etiya.catalogservice.entities.ProductOffer;
import com.etiya.catalogservice.services.dtos.requests.productOfferRequests.CreateProductOfferRequest;
import com.etiya.catalogservice.services.dtos.requests.productOfferRequests.UpdateProductOfferRequest;
import com.etiya.catalogservice.services.dtos.responses.productOfferResponses.*;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductOfferMapper {

    ProductOfferMapper INSTANCE = Mappers.getMapper(ProductOfferMapper.class);

    GetAllProductOfferResponse getAllProductOfferResponseFromProductOffer(ProductOffer productOffer);

    GetProductOfferResponse getProductOfferResponseFromProductOffer(ProductOffer productOffer);

    ProductOffer getProductOfferFromCreateProductOfferRequest(CreateProductOfferRequest createProductOfferRequest);

    CreatedProductOfferResponse getCreatedProductOfferResponseFromProductOffer(ProductOffer productOffer);

    ProductOffer getProductOfferFromUpdateProductOfferRequest(UpdateProductOfferRequest updateProductOfferRequest);

    UpdatedProductOfferResponse getUpdatedProductOfferResponseFromProductOffer(ProductOffer productOffer);

    DeletedProductOfferResponse getDeletedProductOfferResponseFromProductOffer(ProductOffer productOffer);
}

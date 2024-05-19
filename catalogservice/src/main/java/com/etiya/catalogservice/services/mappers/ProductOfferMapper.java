package com.etiya.catalogservice.services.mappers;

import com.etiya.catalogservice.entities.ProductOffer;
import com.etiya.catalogservice.services.dtos.requests.productOfferRequests.CreateProductOfferRequest;
import com.etiya.catalogservice.services.dtos.requests.productOfferRequests.UpdateProductOfferRequest;
import com.etiya.catalogservice.services.dtos.responses.productOfferResponses.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductOfferMapper {

    ProductOfferMapper INSTANCE = Mappers.getMapper(ProductOfferMapper.class);

    @Mapping(source = "productOffer.product.id", target = "productId")
    GetAllProductOfferResponse getAllProductOfferResponseFromProductOffer(ProductOffer productOffer);

    @Mapping(source = "productOffer.product.id", target = "productId")
    GetProductOfferResponse getProductOfferResponseFromProductOffer(ProductOffer productOffer);

    @Mapping(source = "productId", target = "product.id")
    ProductOffer getProductOfferFromCreateProductOfferRequest(CreateProductOfferRequest createProductOfferRequest);

    @Mapping(source = "productOffer.product.id", target = "productId")
    CreatedProductOfferResponse getCreatedProductOfferResponseFromProductOffer(ProductOffer productOffer);

    @Mapping(source = "productId", target = "product.id")
    ProductOffer getProductOfferFromUpdateProductOfferRequest(UpdateProductOfferRequest updateProductOfferRequest);

    @Mapping(source = "productOffer.product.id", target = "productId")
    UpdatedProductOfferResponse getUpdatedProductOfferResponseFromProductOffer(ProductOffer productOffer);

    DeletedProductOfferResponse getDeletedProductOfferResponseFromProductOffer(ProductOffer productOffer);
}

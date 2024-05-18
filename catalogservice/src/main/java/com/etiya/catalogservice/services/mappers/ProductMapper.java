package com.etiya.catalogservice.services.mappers;

import com.etiya.catalogservice.entities.Product;
import com.etiya.catalogservice.services.dtos.requests.productRequests.CreateProductRequest;
import com.etiya.catalogservice.services.dtos.requests.productRequests.UpdateProductRequest;
import com.etiya.catalogservice.services.dtos.responses.productResponses.*;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    GetAllProductResponse getAllProductResponseFromProduct(Product product);

    GetProductResponse getProductResponseFromProduct(Product product);

    Product getProductFromCreateProductRequest(CreateProductRequest createProductRequest);

    CreatedProductResponse getCreatedProductResponseFromProduct(Product product);

    Product getProductFromUpdateProductRequest(UpdateProductRequest updateProductRequest);

    UpdatedProductResponse getUpdatedProductResponseFromProduct(Product product);

    DeletedProductResponse getDeletedProductResponseFromProduct(Product product);
}

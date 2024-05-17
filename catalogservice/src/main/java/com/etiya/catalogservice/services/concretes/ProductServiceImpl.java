package com.etiya.catalogservice.services.concretes;

import com.etiya.catalogservice.core.business.paging.PageInfo;
import com.etiya.catalogservice.core.responses.GetListResponse;
import com.etiya.catalogservice.repositories.ProductRepository;
import com.etiya.catalogservice.services.abstracts.ProductService;
import com.etiya.catalogservice.services.dtos.requests.productRequests.CreateProductRequest;
import com.etiya.catalogservice.services.dtos.requests.productRequests.UpdateProductRequest;
import com.etiya.catalogservice.services.dtos.responses.productResponses.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    @Override
    public GetListResponse<GetAllProductResponse> getAll(PageInfo pageInfo) {
        return null;
    }

    @Override
    public GetProductResponse getById(String id) {
        return null;
    }

    @Override
    public CreatedProductResponse add(CreateProductRequest createProductRequest) {
        return null;
    }

    @Override
    public UpdatedProductResponse update(UpdateProductRequest updateProductRequest, String id) {
        return null;
    }

    @Override
    public DeletedProductResponse delete(String id) {
        return null;
    }
}

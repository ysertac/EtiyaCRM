package com.etiya.catalogservice.services.abstracts;

import com.etiya.catalogservice.core.business.paging.PageInfo;
import com.etiya.catalogservice.core.responses.GetListResponse;
import com.etiya.catalogservice.services.dtos.requests.productRequests.CreateProductRequest;
import com.etiya.catalogservice.services.dtos.requests.productRequests.UpdateProductRequest;
import com.etiya.catalogservice.services.dtos.responses.productResponses.*;

public interface ProductService {
    GetListResponse<GetAllProductResponse> getAll(PageInfo pageInfo);

    GetProductResponse getById(String id);

    CreatedProductResponse add(CreateProductRequest createProductRequest);

    UpdatedProductResponse update(UpdateProductRequest updateProductRequest, String id);

    DeletedProductResponse delete(String id);
}

package com.etiya.catalogservice.services.abstracts;

import com.etiya.catalogservice.core.business.paging.PageInfo;
import com.etiya.catalogservice.core.responses.GetListResponse;
import com.etiya.catalogservice.services.dtos.requests.productOfferRequests.CreateProductOfferRequest;
import com.etiya.catalogservice.services.dtos.requests.productOfferRequests.UpdateProductOfferRequest;
import com.etiya.catalogservice.services.dtos.responses.productOfferResponses.*;

public interface ProductOfferService {
    GetListResponse<GetAllProductOfferResponse> getAll(PageInfo pageInfo);

    GetProductOfferResponse getById(String id);

    CreatedProductOfferResponse add(CreateProductOfferRequest createProductOfferRequest);

    UpdatedProductOfferResponse update(UpdateProductOfferRequest updateProductOfferRequest, String id);

    DeletedProductOfferResponse delete(String id);
}

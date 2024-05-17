package com.etiya.catalogservice.services.concretes;

import com.etiya.catalogservice.core.business.paging.PageInfo;
import com.etiya.catalogservice.core.responses.GetListResponse;
import com.etiya.catalogservice.repositories.ProductOfferRepository;
import com.etiya.catalogservice.services.abstracts.ProductOfferService;
import com.etiya.catalogservice.services.dtos.requests.productOfferRequests.CreateProductOfferRequest;
import com.etiya.catalogservice.services.dtos.requests.productOfferRequests.UpdateProductOfferRequest;
import com.etiya.catalogservice.services.dtos.responses.productOfferResponses.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductOfferServiceImpl implements ProductOfferService {

    private ProductOfferRepository productOfferRepository;

    @Override
    public GetListResponse<GetAllProductOfferResponse> getAll(PageInfo pageInfo) {
        return null;
    }

    @Override
    public GetProductOfferResponse getById(String id) {
        return null;
    }

    @Override
    public CreatedProductOfferResponse add(CreateProductOfferRequest createProductOfferRequest) {
        return null;
    }

    @Override
    public UpdatedProductOfferResponse update(UpdateProductOfferRequest updateProductOfferRequest, String id) {
        return null;
    }

    @Override
    public DeletedProductOfferResponse delete(String id) {
        return null;
    }
}

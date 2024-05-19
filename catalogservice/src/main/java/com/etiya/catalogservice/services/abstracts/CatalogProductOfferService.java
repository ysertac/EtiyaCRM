package com.etiya.catalogservice.services.abstracts;

import com.etiya.catalogservice.core.business.paging.PageInfo;
import com.etiya.catalogservice.core.responses.GetListResponse;
import com.etiya.catalogservice.services.dtos.requests.catalogProductOfferRequests.CreateCatalogProductOfferRequest;
import com.etiya.catalogservice.services.dtos.responses.catalogProductOfferResponses.*;

public interface CatalogProductOfferService {
    CreatedCatalogProductOfferResponse add(CreateCatalogProductOfferRequest createCatalogProductOfferRequest);

    GetListResponse<GetAllCatalogProductOfferResponse> getAll(PageInfo pageInfo);

    GetCatalogProductOfferResponse getById(String id);
    DeletedCatalogProductOfferResponse delete(String id);
}

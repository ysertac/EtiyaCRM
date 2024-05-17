package com.etiya.catalogservice.services.abstracts;

import com.etiya.catalogservice.core.business.paging.PageInfo;
import com.etiya.catalogservice.core.responses.GetListResponse;
import com.etiya.catalogservice.services.dtos.requests.catalogRequests.CreateCatalogRequest;
import com.etiya.catalogservice.services.dtos.requests.catalogRequests.UpdateCatalogRequest;
import com.etiya.catalogservice.services.dtos.responses.catalogResponses.*;

public interface CatalogService {
    GetListResponse<GetAllCatalogResponse> getAll(PageInfo pageInfo);

    GetCatalogResponse getById(String id);

    CreatedCatalogResponse add(CreateCatalogRequest createCatalogRequest);

    UpdatedCatalogResponse update(UpdateCatalogRequest updateCatalogRequest, String id);

    DeletedCatalogResponse delete(String id);
}

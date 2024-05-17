package com.etiya.catalogservice.services.concretes;

import com.etiya.catalogservice.core.business.paging.PageInfo;
import com.etiya.catalogservice.core.responses.GetListResponse;
import com.etiya.catalogservice.repositories.CatalogRepository;
import com.etiya.catalogservice.services.abstracts.CatalogService;
import com.etiya.catalogservice.services.dtos.requests.catalogRequests.CreateCatalogRequest;
import com.etiya.catalogservice.services.dtos.requests.catalogRequests.UpdateCatalogRequest;
import com.etiya.catalogservice.services.dtos.responses.catalogResponses.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CatalogServiceImpl implements CatalogService {

    private CatalogRepository catalogRepository;

    @Override
    public GetListResponse<GetAllCatalogResponse> getAll(PageInfo pageInfo) {
        return null;
    }

    @Override
    public GetCatalogResponse getById(String id) {
        return null;
    }

    @Override
    public CreatedCatalogResponse add(CreateCatalogRequest createCatalogRequest) {
        return null;
    }

    @Override
    public UpdatedCatalogResponse update(UpdateCatalogRequest updateCatalogRequest, String id) {
        return null;
    }

    @Override
    public DeletedCatalogResponse delete(String id) {
        return null;
    }
}

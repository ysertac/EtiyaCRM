package com.etiya.catalogservice.services.concretes;

import com.etiya.catalogservice.core.business.paging.PageInfo;
import com.etiya.catalogservice.core.responses.GetListResponse;
import com.etiya.catalogservice.entities.Campaign;
import com.etiya.catalogservice.entities.Catalog;
import com.etiya.catalogservice.repositories.CatalogRepository;
import com.etiya.catalogservice.services.abstracts.CatalogService;
import com.etiya.catalogservice.services.dtos.requests.catalogRequests.CreateCatalogRequest;
import com.etiya.catalogservice.services.dtos.requests.catalogRequests.UpdateCatalogRequest;
import com.etiya.catalogservice.services.dtos.responses.campaignResponses.DeletedCampaignResponse;
import com.etiya.catalogservice.services.dtos.responses.campaignResponses.GetAllCampaignResponse;
import com.etiya.catalogservice.services.dtos.responses.campaignResponses.GetCampaignResponse;
import com.etiya.catalogservice.services.dtos.responses.campaignResponses.UpdatedCampaignResponse;
import com.etiya.catalogservice.services.dtos.responses.catalogResponses.*;
import com.etiya.catalogservice.services.mappers.CampaignMapper;
import com.etiya.catalogservice.services.mappers.CatalogMapper;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CatalogServiceImpl implements CatalogService {

    private CatalogRepository catalogRepository;

    @Override
    public GetListResponse<GetAllCatalogResponse> getAll(PageInfo pageInfo) {
        GetListResponse<GetAllCatalogResponse> response = new GetListResponse<>();
        Pageable pageable = PageRequest.of(pageInfo.getPage(), pageInfo.getSize());
        Page<Catalog> catalogs = catalogRepository.findAll(pageable);
        response.setItems(catalogs.stream().map(CatalogMapper.INSTANCE::getAllCatalogResponseFromCatalog).collect(Collectors.toList()));
        response.setTotalElements(catalogs.getTotalElements());
        response.setTotalPage(catalogs.getTotalPages());
        response.setSize(catalogs.getSize());
        response.setHasNext(catalogs.hasNext());
        response.setHasPrevious(catalogs.hasPrevious());
        return response;
    }

    @Override
    public GetCatalogResponse getById(String id) {
        Catalog foundCatalog = catalogRepository.findById(id).get();
        GetCatalogResponse getCatalogResponse = CatalogMapper.INSTANCE.getCatalogResponseFromCatalog(foundCatalog);
        return getCatalogResponse;
    }

    @Override
    public CreatedCatalogResponse add(CreateCatalogRequest createCatalogRequest) {
        Catalog catalog = CatalogMapper.INSTANCE.catalogFromCreateCatalogRequest(createCatalogRequest);
        catalog.setCreatedDate(LocalDateTime.now());
        Catalog createdCatalog = catalogRepository.save(catalog);
        return CatalogMapper.INSTANCE.createdCatalogResponseFromCatalog(createdCatalog);
    }

    @Override
    public UpdatedCatalogResponse update(UpdateCatalogRequest updateCatalogRequest, String id) {
        Catalog foundCatalog = catalogRepository.findById(id).get();
        foundCatalog.setUpdatedDate(LocalDateTime.now());

        Catalog catalog = CatalogMapper.INSTANCE.catalogFromUpdateCatalogRequest(updateCatalogRequest);
        catalog.setId(foundCatalog.getId());
        catalog.setCreatedDate(foundCatalog.getCreatedDate());
        catalog.setUpdatedDate(foundCatalog.getUpdatedDate());
        Catalog updatedCatalog = catalogRepository.save(catalog);

        UpdatedCatalogResponse updatedCatalogResponse = CatalogMapper.INSTANCE.updatedCatalogResponseFromCatalog(updatedCatalog);
        return updatedCatalogResponse;
    }

    @Override
    public DeletedCatalogResponse delete(String id) {
        Catalog foundCatalog = catalogRepository.findById(id).get();
        foundCatalog.setDeletedDate(LocalDateTime.now());
        Catalog deletedCatalog = catalogRepository.save(foundCatalog);
        DeletedCatalogResponse deletedCatalogResponse = CatalogMapper.INSTANCE.deletedCatalogResponseFromCatalog(deletedCatalog);
        return deletedCatalogResponse;
    }
}

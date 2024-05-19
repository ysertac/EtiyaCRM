package com.etiya.catalogservice.services.concretes;

import com.etiya.catalogservice.core.business.paging.PageInfo;
import com.etiya.catalogservice.core.responses.GetListResponse;
import com.etiya.catalogservice.entities.CatalogProductOffer;
import com.etiya.catalogservice.repositories.CatalogProductOfferRepository;
import com.etiya.catalogservice.services.abstracts.CatalogProductOfferService;
import com.etiya.catalogservice.services.dtos.requests.catalogProductOfferRequests.CreateCatalogProductOfferRequest;
import com.etiya.catalogservice.services.dtos.responses.catalogProductOfferResponses.*;
import com.etiya.catalogservice.services.mappers.CatalogProductOfferMapper;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CatalogProductOfferServiceImpl implements CatalogProductOfferService {

    private CatalogProductOfferRepository catalogProductOfferRepository;

    @Override
    public CreatedCatalogProductOfferResponse add(CreateCatalogProductOfferRequest createCatalogProductOfferRequest) {
        CatalogProductOffer catalogProductOffer = CatalogProductOfferMapper.INSTANCE.catalogProductOfferFromCreateCatalogProductOfferRequest(createCatalogProductOfferRequest);
        catalogProductOffer.setCreatedDate(LocalDateTime.now());
        CatalogProductOffer createdCatalogProductOffer = catalogProductOfferRepository.save(catalogProductOffer);
        return CatalogProductOfferMapper.INSTANCE.createdCatalogProductOfferResponseFromCatalogProductOffer(createdCatalogProductOffer);
    }

    @Override
    public GetListResponse<GetAllCatalogProductOfferResponse> getAll(PageInfo pageInfo) {
        GetListResponse<GetAllCatalogProductOfferResponse> response = new GetListResponse<>();
        Pageable pageable = PageRequest.of(pageInfo.getPage(), pageInfo.getSize());
        Page<CatalogProductOffer> catalogProductOffers = catalogProductOfferRepository.findAll(pageable);
        response.setItems(catalogProductOffers.stream().map(CatalogProductOfferMapper.INSTANCE::getAllCatalogProductOfferResponseFromCatalogProductOffer).collect(Collectors.toList()));
        response.setTotalElements(catalogProductOffers.getTotalElements());
        response.setTotalPage(catalogProductOffers.getTotalPages());
        response.setSize(catalogProductOffers.getSize());
        response.setHasNext(catalogProductOffers.hasNext());
        response.setHasPrevious(catalogProductOffers.hasPrevious());
        return response;
    }

    @Override
    public GetCatalogProductOfferResponse getById(String id) {
        CatalogProductOffer foundCatalogProductOffer = catalogProductOfferRepository.findById(id).get();
        GetCatalogProductOfferResponse getCatalogProductOfferResponse = CatalogProductOfferMapper.INSTANCE.getCatalogProductOfferResponseFromCatalogProductOffer(foundCatalogProductOffer);
        return getCatalogProductOfferResponse;
    }

    @Override
    public DeletedCatalogProductOfferResponse delete(String id) {
        CatalogProductOffer foundCatalogProductOffer = catalogProductOfferRepository.findById(id).get();
        foundCatalogProductOffer.setDeletedDate(LocalDateTime.now());
        CatalogProductOffer deletedCatalogProductOffer = catalogProductOfferRepository.save(foundCatalogProductOffer);
        DeletedCatalogProductOfferResponse deletedCatalogProductOfferResponse = CatalogProductOfferMapper.INSTANCE.deletedCatalogProductOfferResponseFromCatalogProductOffer(deletedCatalogProductOffer);
        return deletedCatalogProductOfferResponse;
    }
}

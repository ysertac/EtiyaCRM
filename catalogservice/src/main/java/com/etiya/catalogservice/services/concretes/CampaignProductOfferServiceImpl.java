package com.etiya.catalogservice.services.concretes;

import com.etiya.catalogservice.core.business.paging.PageInfo;
import com.etiya.catalogservice.core.responses.GetListResponse;
import com.etiya.catalogservice.entities.CampaignProductOffer;
import com.etiya.catalogservice.entities.CatalogProductOffer;
import com.etiya.catalogservice.repositories.CampaignProductOfferRepository;
import com.etiya.catalogservice.services.abstracts.CampaignProductOfferService;
import com.etiya.catalogservice.services.dtos.requests.campaignProductOfferRequests.CreateCampaignProductOfferRequest;
import com.etiya.catalogservice.services.dtos.responses.campaignProductOfferResponses.CreatedCampaignProductOfferResponse;
import com.etiya.catalogservice.services.dtos.responses.campaignProductOfferResponses.DeletedCampaignProductOfferResponse;
import com.etiya.catalogservice.services.dtos.responses.campaignProductOfferResponses.GetAllCampaignProductOfferResponse;
import com.etiya.catalogservice.services.dtos.responses.campaignProductOfferResponses.GetCampaignProductOfferResponse;
import com.etiya.catalogservice.services.dtos.responses.catalogProductOfferResponses.DeletedCatalogProductOfferResponse;
import com.etiya.catalogservice.services.dtos.responses.catalogProductOfferResponses.GetAllCatalogProductOfferResponse;
import com.etiya.catalogservice.services.dtos.responses.catalogProductOfferResponses.GetCatalogProductOfferResponse;
import com.etiya.catalogservice.services.mappers.CampaignProductOfferMapper;
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
public class CampaignProductOfferServiceImpl implements CampaignProductOfferService {

    private CampaignProductOfferRepository campaignProductOfferRepository;

    @Override
    public CreatedCampaignProductOfferResponse add(CreateCampaignProductOfferRequest createCampaignProductOfferRequest) {
        CampaignProductOffer campaignProductOffer = CampaignProductOfferMapper.INSTANCE.campaignProductOfferFromCreateCampaignProductOfferRequest(createCampaignProductOfferRequest);
        campaignProductOffer.setCreatedDate(LocalDateTime.now());
        CampaignProductOffer createdCampaignProductOffer = campaignProductOfferRepository.save(campaignProductOffer);
        return CampaignProductOfferMapper.INSTANCE.createdCampaignProductOfferResponseFromCampaignProductOffer(createdCampaignProductOffer);
    }

    @Override
    public GetListResponse<GetAllCampaignProductOfferResponse> getAll(PageInfo pageInfo) {
        GetListResponse<GetAllCampaignProductOfferResponse> response = new GetListResponse<>();
        Pageable pageable = PageRequest.of(pageInfo.getPage(), pageInfo.getSize());
        Page<CampaignProductOffer> campaignProductOffers = campaignProductOfferRepository.findAll(pageable);
        response.setItems(campaignProductOffers.stream().map(CampaignProductOfferMapper.INSTANCE::getAllCampaignProductOfferResponseFromCampaignProductOffer).collect(Collectors.toList()));
        response.setTotalElements(campaignProductOffers.getTotalElements());
        response.setTotalPage(campaignProductOffers.getTotalPages());
        response.setSize(campaignProductOffers.getSize());
        response.setHasNext(campaignProductOffers.hasNext());
        response.setHasPrevious(campaignProductOffers.hasPrevious());
        return response;
    }

    @Override
    public GetCampaignProductOfferResponse getById(String id) {
        CampaignProductOffer foundCampaignProductOffer = campaignProductOfferRepository.findById(id).get();
        GetCampaignProductOfferResponse getCampaignProductOfferResponse = CampaignProductOfferMapper.INSTANCE.getCampaignProductOfferResponseFromCampaignProductOffer(foundCampaignProductOffer);
        return getCampaignProductOfferResponse;
    }

    @Override
    public DeletedCampaignProductOfferResponse delete(String id) {
        CampaignProductOffer foundCampaignProductOffer = campaignProductOfferRepository.findById(id).get();
        foundCampaignProductOffer.setDeletedDate(LocalDateTime.now());
        CampaignProductOffer deletedCampaignProductOffer = campaignProductOfferRepository.save(foundCampaignProductOffer);
        DeletedCampaignProductOfferResponse deletedCampaignProductOfferResponse = CampaignProductOfferMapper.INSTANCE.deletedCampaignProductOfferResponseFromCampaignProductOffer(deletedCampaignProductOffer);
        return deletedCampaignProductOfferResponse;
    }
}

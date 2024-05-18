package com.etiya.catalogservice.services.concretes;

import com.etiya.catalogservice.core.business.paging.PageInfo;
import com.etiya.catalogservice.core.responses.GetListResponse;
import com.etiya.catalogservice.entities.Campaign;
import com.etiya.catalogservice.repositories.CampaignRepository;
import com.etiya.catalogservice.services.abstracts.CampaignService;
import com.etiya.catalogservice.services.dtos.requests.campaignRequests.CreateCampaignRequest;
import com.etiya.catalogservice.services.dtos.requests.campaignRequests.UpdateCampaignRequest;
import com.etiya.catalogservice.services.dtos.responses.campaignResponses.*;
import com.etiya.catalogservice.services.mappers.CampaignMapper;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CampaignServiceImpl implements CampaignService {

    private CampaignRepository campaignRepository;

    @Override
    public GetListResponse<GetAllCampaignResponse> getAll(PageInfo pageInfo) {
        GetListResponse<GetAllCampaignResponse> response = new GetListResponse<>();
        Pageable pageable = PageRequest.of(pageInfo.getPage(), pageInfo.getSize());
        Page<Campaign> campaigns = campaignRepository.findAll(pageable);
        response.setItems(campaigns.stream().map(CampaignMapper.INSTANCE::getAllCampaignResponseFromCampaign).collect(Collectors.toList()));
        response.setTotalElements(campaigns.getTotalElements());
        response.setTotalPage(campaigns.getTotalPages());
        response.setSize(campaigns.getSize());
        response.setHasNext(campaigns.hasNext());
        response.setHasPrevious(campaigns.hasPrevious());
        return response;
    }

    @Override
    public GetCampaignResponse getById(String id) {
        Campaign foundCampaign = campaignRepository.findById(id).get();
        GetCampaignResponse getCampaignResponse = CampaignMapper.INSTANCE.getCampaignResponseFromCampaign(foundCampaign);
        return getCampaignResponse;
    }

    @Override
    public CreatedCampaignResponse add(CreateCampaignRequest createCampaignRequest) {
        Campaign campaign = CampaignMapper.INSTANCE.campaignFromCreateCampaignRequest(createCampaignRequest);
        campaign.setCreatedDate(LocalDateTime.now());
        Campaign createdCampaign = campaignRepository.save(campaign);
        return CampaignMapper.INSTANCE.createdCampaignResponseFromCampaign(createdCampaign);
    }

    @Override
    public UpdatedCampaignResponse update(UpdateCampaignRequest updateCampaignRequest, String id) {
        Campaign foundCampaign = campaignRepository.findById(id).get();
        foundCampaign.setUpdatedDate(LocalDateTime.now());

        Campaign campaign = CampaignMapper.INSTANCE.campaignFromUpdateCampaignRequest(updateCampaignRequest);
        campaign.setId(foundCampaign.getId());
        campaign.setCreatedDate(foundCampaign.getCreatedDate());
        campaign.setUpdatedDate(foundCampaign.getUpdatedDate());
        Campaign updatedCampaign = campaignRepository.save(campaign);

        UpdatedCampaignResponse updatedCampaignResponse = CampaignMapper.INSTANCE.updatedCampaignResponseFromCampaign(updatedCampaign);
        return updatedCampaignResponse;
    }

    @Override
    public DeletedCampaignResponse delete(String id) {
        Campaign foundCampaign = campaignRepository.findById(id).get();
        foundCampaign.setDeletedDate(LocalDateTime.now());
        Campaign deletedCampaign = campaignRepository.save(foundCampaign);

        DeletedCampaignResponse deletedCampaignResponse = CampaignMapper.INSTANCE.deletedCampaignResponseFromCampaign(deletedCampaign);
        return deletedCampaignResponse;
    }
}

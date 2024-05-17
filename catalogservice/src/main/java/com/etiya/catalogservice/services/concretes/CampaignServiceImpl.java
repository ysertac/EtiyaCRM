package com.etiya.catalogservice.services.concretes;

import com.etiya.catalogservice.core.business.paging.PageInfo;
import com.etiya.catalogservice.core.responses.GetListResponse;
import com.etiya.catalogservice.repositories.CampaignRepository;
import com.etiya.catalogservice.services.abstracts.CampaignService;
import com.etiya.catalogservice.services.dtos.requests.campaignRequests.CreateCampaignRequest;
import com.etiya.catalogservice.services.dtos.requests.campaignRequests.UpdateCampaignRequest;
import com.etiya.catalogservice.services.dtos.responses.campaignResponses.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CampaignServiceImpl implements CampaignService {

    private CampaignRepository campaignRepository;

    @Override
    public GetListResponse<GetAllCampaignResponse> getAll(PageInfo pageInfo) {
        return null;
    }

    @Override
    public GetCampaignResponse getById(String id) {
        return null;
    }

    @Override
    public CreatedCampaignResponse add(CreateCampaignRequest createCampaignRequest) {
        return null;
    }

    @Override
    public UpdatedCampaignResponse update(UpdateCampaignRequest updateCampaignRequest, String id) {
        return null;
    }

    @Override
    public DeletedCampaignResponse delete(String id) {
        return null;
    }
}

package com.etiya.catalogservice.services.abstracts;

import com.etiya.catalogservice.core.business.paging.PageInfo;
import com.etiya.catalogservice.core.responses.GetListResponse;
import com.etiya.catalogservice.services.dtos.requests.campaignRequests.CreateCampaignRequest;
import com.etiya.catalogservice.services.dtos.requests.campaignRequests.UpdateCampaignRequest;
import com.etiya.catalogservice.services.dtos.responses.campaignResponses.*;

public interface CampaignService {
    GetListResponse<GetAllCampaignResponse> getAll(PageInfo pageInfo);

    GetCampaignResponse getById(String id);

    CreatedCampaignResponse add(CreateCampaignRequest createCampaignRequest);

    UpdatedCampaignResponse update(UpdateCampaignRequest updateCampaignRequest, String id);

    DeletedCampaignResponse delete(String id);
}

package com.etiya.catalogservice.services.abstracts;

import com.etiya.catalogservice.core.business.paging.PageInfo;
import com.etiya.catalogservice.core.responses.GetListResponse;
import com.etiya.catalogservice.services.dtos.requests.campaignProductOfferRequests.CreateCampaignProductOfferRequest;
import com.etiya.catalogservice.services.dtos.responses.campaignProductOfferResponses.CreatedCampaignProductOfferResponse;
import com.etiya.catalogservice.services.dtos.responses.campaignProductOfferResponses.DeletedCampaignProductOfferResponse;
import com.etiya.catalogservice.services.dtos.responses.campaignProductOfferResponses.GetAllCampaignProductOfferResponse;
import com.etiya.catalogservice.services.dtos.responses.campaignProductOfferResponses.GetCampaignProductOfferResponse;

public interface CampaignProductOfferService {
    CreatedCampaignProductOfferResponse add(CreateCampaignProductOfferRequest createCampaignProductOfferRequest);

    GetListResponse<GetAllCampaignProductOfferResponse> getAll(PageInfo pageInfo);

    GetCampaignProductOfferResponse getById(String id);

    DeletedCampaignProductOfferResponse delete(String id);
}

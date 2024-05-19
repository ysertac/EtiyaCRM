package com.etiya.catalogservice.controllers;

import com.etiya.catalogservice.core.business.paging.PageInfo;
import com.etiya.catalogservice.core.responses.GetListResponse;
import com.etiya.catalogservice.services.abstracts.CampaignProductOfferService;
import com.etiya.catalogservice.services.abstracts.CatalogProductOfferService;
import com.etiya.catalogservice.services.dtos.requests.campaignProductOfferRequests.CreateCampaignProductOfferRequest;
import com.etiya.catalogservice.services.dtos.requests.catalogProductOfferRequests.CreateCatalogProductOfferRequest;
import com.etiya.catalogservice.services.dtos.responses.campaignProductOfferResponses.CreatedCampaignProductOfferResponse;
import com.etiya.catalogservice.services.dtos.responses.campaignProductOfferResponses.DeletedCampaignProductOfferResponse;
import com.etiya.catalogservice.services.dtos.responses.campaignProductOfferResponses.GetAllCampaignProductOfferResponse;
import com.etiya.catalogservice.services.dtos.responses.campaignProductOfferResponses.GetCampaignProductOfferResponse;
import com.etiya.catalogservice.services.dtos.responses.catalogProductOfferResponses.CreatedCatalogProductOfferResponse;
import com.etiya.catalogservice.services.dtos.responses.catalogProductOfferResponses.DeletedCatalogProductOfferResponse;
import com.etiya.catalogservice.services.dtos.responses.catalogProductOfferResponses.GetAllCatalogProductOfferResponse;
import com.etiya.catalogservice.services.dtos.responses.catalogProductOfferResponses.GetCatalogProductOfferResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@AllArgsConstructor
@RequestMapping("api/v1/campaignproductoffers")
public class CampaignProductOfferController {

    private CampaignProductOfferService campaignProductOfferService;

    @PostMapping
    public CreatedCampaignProductOfferResponse add(@RequestBody CreateCampaignProductOfferRequest createCampaignProductOfferRequest) {
        return campaignProductOfferService.add(createCampaignProductOfferRequest);
    }

    @GetMapping()
    public GetListResponse<GetAllCampaignProductOfferResponse> getAll(@RequestParam int page, @RequestParam int size) {
        return campaignProductOfferService.getAll(new PageInfo(page, size));
    }

    @GetMapping("/{id}")
    public GetCampaignProductOfferResponse getById(@PathVariable String id) {
        return campaignProductOfferService.getById(id);
    }

    @DeleteMapping("/{id}")
    public DeletedCampaignProductOfferResponse delete(@PathVariable String id) {
        return campaignProductOfferService.delete(id);
    }
}

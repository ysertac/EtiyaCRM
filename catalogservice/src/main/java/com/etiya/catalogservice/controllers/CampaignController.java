package com.etiya.catalogservice.controllers;

import com.etiya.catalogservice.core.business.paging.PageInfo;
import com.etiya.catalogservice.core.responses.GetListResponse;
import com.etiya.catalogservice.services.abstracts.CampaignService;
import com.etiya.catalogservice.services.dtos.requests.campaignRequests.CreateCampaignRequest;
import com.etiya.catalogservice.services.dtos.requests.campaignRequests.UpdateCampaignRequest;
import com.etiya.catalogservice.services.dtos.responses.campaignResponses.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@AllArgsConstructor
@RequestMapping("api/v1/campaigns")
public class CampaignController {

    private CampaignService campaignService;

    @PostMapping
    public CreatedCampaignResponse add(@RequestBody CreateCampaignRequest createCampaignRequest) {
        return campaignService.add(createCampaignRequest);
    }

    @GetMapping()
    public GetListResponse<GetAllCampaignResponse> getAll(@RequestParam int page, @RequestParam int size) {
        return campaignService.getAll(new PageInfo(page, size));
    }

    @GetMapping("/{id}")
    public GetCampaignResponse getById(@PathVariable String id) {
        return campaignService.getById(id);
    }

    @PutMapping("/{id}")
    public UpdatedCampaignResponse update(@RequestBody UpdateCampaignRequest updateCampaignRequest, @PathVariable String id) {
        return campaignService.update(updateCampaignRequest, id);
    }

    @DeleteMapping("/{id}")
    public DeletedCampaignResponse delete(@PathVariable String id) {
        return campaignService.delete(id);
    }
}

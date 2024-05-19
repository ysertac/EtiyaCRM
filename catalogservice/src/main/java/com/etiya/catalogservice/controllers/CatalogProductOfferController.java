package com.etiya.catalogservice.controllers;

import com.etiya.catalogservice.core.business.paging.PageInfo;
import com.etiya.catalogservice.core.responses.GetListResponse;
import com.etiya.catalogservice.services.abstracts.CatalogProductOfferService;
import com.etiya.catalogservice.services.dtos.requests.catalogProductOfferRequests.CreateCatalogProductOfferRequest;
import com.etiya.catalogservice.services.dtos.responses.catalogProductOfferResponses.*;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@AllArgsConstructor
@RequestMapping("api/v1/catalogproductoffers")
public class CatalogProductOfferController {

    private CatalogProductOfferService catalogProductOfferService;

    @PostMapping
    public CreatedCatalogProductOfferResponse add(@RequestBody CreateCatalogProductOfferRequest createCatalogProductOfferRequest) {
        return catalogProductOfferService.add(createCatalogProductOfferRequest);
    }

    @GetMapping()
    public GetListResponse<GetAllCatalogProductOfferResponse> getAll(@RequestParam int page, @RequestParam int size) {
        return catalogProductOfferService.getAll(new PageInfo(page, size));
    }

    @GetMapping("/{id}")
    public GetCatalogProductOfferResponse getById(@PathVariable String id) {
        return catalogProductOfferService.getById(id);
    }

    @DeleteMapping("/{id}")
    public DeletedCatalogProductOfferResponse delete(@PathVariable String id) {
        return catalogProductOfferService.delete(id);
    }
}

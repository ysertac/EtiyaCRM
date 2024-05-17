package com.etiya.catalogservice.controllers;

import com.etiya.catalogservice.core.business.paging.PageInfo;
import com.etiya.catalogservice.core.responses.GetListResponse;
import com.etiya.catalogservice.services.abstracts.CatalogService;
import com.etiya.catalogservice.services.dtos.requests.catalogRequests.CreateCatalogRequest;
import com.etiya.catalogservice.services.dtos.requests.catalogRequests.UpdateCatalogRequest;
import com.etiya.catalogservice.services.dtos.responses.catalogResponses.*;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@AllArgsConstructor
@RequestMapping("api/v1/catalogs")
public class CatalogController {

    private CatalogService catalogService;

    @PostMapping
    public CreatedCatalogResponse add(@RequestBody CreateCatalogRequest createCatalogRequest) {
        return catalogService.add(createCatalogRequest);
    }

    @GetMapping()
    public GetListResponse<GetAllCatalogResponse> getAll(@RequestParam int page, @RequestParam int size) {
        return catalogService.getAll(new PageInfo(page, size));
    }

    @GetMapping("/{id}")
    public GetCatalogResponse getById(@PathVariable String id) {
        return catalogService.getById(id);
    }

    @PutMapping("/{id}")
    public UpdatedCatalogResponse update(@RequestBody UpdateCatalogRequest updateCatalogRequest, @PathVariable String id) {
        return catalogService.update(updateCatalogRequest, id);
    }

    @DeleteMapping("/{id}")
    public DeletedCatalogResponse delete(@PathVariable String id) {
        return catalogService.delete(id);
    }
}

package com.etiya.catalogservice.controllers;

import com.etiya.catalogservice.core.business.paging.PageInfo;
import com.etiya.catalogservice.core.responses.GetListResponse;
import com.etiya.catalogservice.services.abstracts.ProductOfferService;
import com.etiya.catalogservice.services.dtos.requests.productOfferRequests.CreateProductOfferRequest;
import com.etiya.catalogservice.services.dtos.requests.productOfferRequests.UpdateProductOfferRequest;
import com.etiya.catalogservice.services.dtos.responses.productOfferResponses.*;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@AllArgsConstructor
@RequestMapping("api/v1/product-offers")
public class ProductOfferController {

    private ProductOfferService productOfferService;

    @PostMapping
    public CreatedProductOfferResponse add(@RequestBody CreateProductOfferRequest createProductOfferRequest) {
        return productOfferService.add(createProductOfferRequest);
    }

    @GetMapping()
    public GetListResponse<GetAllProductOfferResponse> getAll(@RequestParam int page, @RequestParam int size) {
        return productOfferService.getAll(new PageInfo(page, size));
    }

    @GetMapping("/{id}")
    public GetProductOfferResponse getById(@PathVariable String id) {
        return productOfferService.getById(id);
    }

    @PutMapping("/{id}")
    public UpdatedProductOfferResponse update(@RequestBody UpdateProductOfferRequest updateProductOfferRequest, @PathVariable String id) {
        return productOfferService.update(updateProductOfferRequest, id);
    }

    @DeleteMapping("/{id}")
    public DeletedProductOfferResponse delete(@PathVariable String id) {
        return productOfferService.delete(id);
    }
}

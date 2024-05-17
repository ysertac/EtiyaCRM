package com.etiya.catalogservice.controllers;

import com.etiya.catalogservice.core.business.paging.PageInfo;
import com.etiya.catalogservice.core.responses.GetListResponse;
import com.etiya.catalogservice.services.abstracts.ProductService;
import com.etiya.catalogservice.services.dtos.requests.productRequests.CreateProductRequest;
import com.etiya.catalogservice.services.dtos.requests.productRequests.UpdateProductRequest;
import com.etiya.catalogservice.services.dtos.responses.productResponses.*;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@AllArgsConstructor
@RequestMapping("api/v1/products")
public class ProductController {

    private ProductService productService;

    @PostMapping
    public CreatedProductResponse add(@RequestBody CreateProductRequest createProductRequest) {
        return productService.add(createProductRequest);
    }

    @GetMapping()
    public GetListResponse<GetAllProductResponse> getAll(@RequestParam int page, @RequestParam int size) {
        return productService.getAll(new PageInfo(page, size));
    }

    @GetMapping("/{id}")
    public GetProductResponse getById(@PathVariable String id) {
        return productService.getById(id);
    }

    @PutMapping("/{id}")
    public UpdatedProductResponse update(@RequestBody UpdateProductRequest updateProductRequest, @PathVariable String id) {
        return productService.update(updateProductRequest, id);
    }

    @DeleteMapping("/{id}")
    public DeletedProductResponse delete(@PathVariable String id) {
        return productService.delete(id);
    }
}

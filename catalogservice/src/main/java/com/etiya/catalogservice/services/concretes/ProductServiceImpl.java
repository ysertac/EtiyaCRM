package com.etiya.catalogservice.services.concretes;

import com.etiya.catalogservice.core.business.paging.PageInfo;
import com.etiya.catalogservice.core.responses.GetListResponse;
import com.etiya.catalogservice.entities.Product;
import com.etiya.catalogservice.repositories.ProductRepository;
import com.etiya.catalogservice.services.abstracts.ProductService;
import com.etiya.catalogservice.services.dtos.requests.productRequests.CreateProductRequest;
import com.etiya.catalogservice.services.dtos.requests.productRequests.UpdateProductRequest;
import com.etiya.catalogservice.services.dtos.responses.productResponses.*;
import com.etiya.catalogservice.services.mappers.ProductMapper;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    @Override
    public GetListResponse<GetAllProductResponse> getAll(PageInfo pageInfo) {
        GetListResponse<GetAllProductResponse> response = new GetListResponse<>();
        Pageable pageable = PageRequest.of(pageInfo.getPage(), pageInfo.getSize());
        Page<Product> products = productRepository.findAll(pageable);
        response.setItems(products.stream().map(ProductMapper.INSTANCE::getAllProductResponseFromProduct).collect(Collectors.toList()));
        response.setTotalElements(products.getTotalElements());
        response.setTotalPage(products.getTotalPages());
        response.setSize(products.getSize());
        response.setHasNext(products.hasNext());
        response.setHasPrevious(products.hasPrevious());
        return response;
    }

    @Override
    public GetProductResponse getById(String id) {
        Product product = productRepository.findById(id).get();
        GetProductResponse getProductResponse = ProductMapper.INSTANCE.getProductResponseFromProduct(product);
        return getProductResponse;
    }

    @Override
    public CreatedProductResponse add(CreateProductRequest createProductRequest) {
        Product product = ProductMapper.INSTANCE.getProductFromCreateProductRequest(createProductRequest);
        product.setCreatedDate(LocalDateTime.now());
        Product createdProduct = productRepository.save(product);
        return ProductMapper.INSTANCE.getCreatedProductResponseFromProduct(createdProduct);
    }

    @Override
    public UpdatedProductResponse update(UpdateProductRequest updateProductRequest, String id) {
        Product foundProduct = productRepository.findById(id).get();
        foundProduct.setUpdatedDate(LocalDateTime.now());

        Product product = ProductMapper.INSTANCE.getProductFromUpdateProductRequest(updateProductRequest);
        product.setId(foundProduct.getId());
        product.setCreatedDate(foundProduct.getCreatedDate());
        product.setUpdatedDate(LocalDateTime.now());
        Product updatedProduct = productRepository.save(product);

        UpdatedProductResponse updatedProductResponse = ProductMapper.INSTANCE.getUpdatedProductResponseFromProduct(updatedProduct);
        return updatedProductResponse;
    }

    @Override
    public DeletedProductResponse delete(String id) {
        Product foundProduct = productRepository.findById(id).get();
        foundProduct.setDeletedDate(LocalDateTime.now());
        Product deletedProduct = productRepository.save(foundProduct);
        DeletedProductResponse deletedProductResponse = ProductMapper.INSTANCE.getDeletedProductResponseFromProduct(deletedProduct);
        return deletedProductResponse;
    }
}

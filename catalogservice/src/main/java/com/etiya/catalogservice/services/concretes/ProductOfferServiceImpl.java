package com.etiya.catalogservice.services.concretes;

import com.etiya.catalogservice.core.business.paging.PageInfo;
import com.etiya.catalogservice.core.responses.GetListResponse;
import com.etiya.catalogservice.entities.ProductOffer;
import com.etiya.catalogservice.repositories.ProductOfferRepository;
import com.etiya.catalogservice.services.abstracts.ProductOfferService;
import com.etiya.catalogservice.services.dtos.requests.productOfferRequests.CreateProductOfferRequest;
import com.etiya.catalogservice.services.dtos.requests.productOfferRequests.UpdateProductOfferRequest;
import com.etiya.catalogservice.services.dtos.responses.productOfferResponses.*;
import com.etiya.catalogservice.services.mappers.ProductOfferMapper;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductOfferServiceImpl implements ProductOfferService {

    private ProductOfferRepository productOfferRepository;

    @Override
    public GetListResponse<GetAllProductOfferResponse> getAll(PageInfo pageInfo) {
        GetListResponse<GetAllProductOfferResponse> response = new GetListResponse<>();
        Pageable pageable = PageRequest.of(pageInfo.getPage(), pageInfo.getSize());
        Page<ProductOffer> productOffers = productOfferRepository.findAll(pageable);
        response.setItems(productOffers.stream().map(ProductOfferMapper.INSTANCE::getAllProductOfferResponseFromProductOffer).collect(Collectors.toList()));
        response.setTotalElements(productOffers.getTotalElements());
        response.setTotalPage(productOffers.getTotalPages());
        response.setSize(productOffers.getSize());
        response.setHasNext(productOffers.hasNext());
        response.setHasPrevious(productOffers.hasPrevious());
        return response;
    }

    @Override
    public GetProductOfferResponse getById(String id) {
        ProductOffer productOffer = productOfferRepository.findById(id).get();
        GetProductOfferResponse getProductOfferResponse = ProductOfferMapper.INSTANCE.getProductOfferResponseFromProductOffer(productOffer);
        return getProductOfferResponse;
    }

    @Override
    public CreatedProductOfferResponse add(CreateProductOfferRequest createProductOfferRequest) {
        ProductOffer productOffer = ProductOfferMapper.INSTANCE.getProductOfferFromCreateProductOfferRequest(createProductOfferRequest);
        productOffer.setCreatedDate(LocalDateTime.now());
        ProductOffer createdProductOffer = productOfferRepository.save(productOffer);
        return ProductOfferMapper.INSTANCE.getCreatedProductOfferResponseFromProductOffer(createdProductOffer);
    }

    @Override
    public UpdatedProductOfferResponse update(UpdateProductOfferRequest updateProductOfferRequest, String id) {
        ProductOffer foundProductOffer = productOfferRepository.findById(id).get();
        foundProductOffer.setUpdatedDate(LocalDateTime.now());

        ProductOffer productOffer = ProductOfferMapper.INSTANCE.getProductOfferFromUpdateProductOfferRequest(updateProductOfferRequest);
        productOffer.setId(foundProductOffer.getId());
        productOffer.setCreatedDate(foundProductOffer.getCreatedDate());
        productOffer.setUpdatedDate(LocalDateTime.now());
        ProductOffer updatedProductOffer = productOfferRepository.save(productOffer);

        UpdatedProductOfferResponse updatedProductOfferResponse = ProductOfferMapper.INSTANCE.getUpdatedProductOfferResponseFromProductOffer(updatedProductOffer);
        return updatedProductOfferResponse;
    }

    @Override
    public DeletedProductOfferResponse delete(String id) {
        ProductOffer foundProductOffer = productOfferRepository.findById(id).get();
        foundProductOffer.setDeletedDate(LocalDateTime.now());
        ProductOffer deletedProductOffer = productOfferRepository.save(foundProductOffer);
        DeletedProductOfferResponse deletedProductOfferResponse = ProductOfferMapper.INSTANCE.getDeletedProductOfferResponseFromProductOffer(deletedProductOffer);
        return deletedProductOfferResponse;
    }
}

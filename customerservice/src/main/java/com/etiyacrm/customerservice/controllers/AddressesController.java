package com.etiyacrm.customerservice.controllers;

import com.etiyacrm.customerservice.core.business.paging.PageInfo;
import com.etiyacrm.customerservice.core.responses.GetListResponse;
import com.etiyacrm.customerservice.services.abstracts.AddressService;
import com.etiyacrm.customerservice.services.dtos.requests.addressRequests.CreateAddressRequest;
import com.etiyacrm.customerservice.services.dtos.requests.addressRequests.UpdateAddressRequest;
import com.etiyacrm.customerservice.services.dtos.responses.addressResponses.*;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("customerservice/api/v1/addresses")
@AllArgsConstructor
public class AddressesController {
    private AddressService addressService;

    @PostMapping
    public CreatedAddressResponse add(@RequestBody CreateAddressRequest createAddressRequest){
        return addressService.add(createAddressRequest);
    }

    @GetMapping
    public GetListResponse<GetAllAddressResponse> getAll(@RequestParam int page,
                                                         @RequestParam int size,
                                                         @RequestParam Optional<String> customerId){
        return addressService.getAll(new PageInfo(page,size),customerId);
    }

    @GetMapping("/{id}")
    public GetAddressResponse getById(@PathVariable String id){
        return addressService.getById(id);
    }

    @PutMapping("/{id}")
    public UpdatedAddressResponse update(@RequestBody UpdateAddressRequest updateAddressRequest, @PathVariable String id){
        return addressService.update(updateAddressRequest, id);
    }

    @DeleteMapping("/{id}")
    public DeletedAddressResponse delete(@PathVariable String id){
        return addressService.delete(id);
    }

}

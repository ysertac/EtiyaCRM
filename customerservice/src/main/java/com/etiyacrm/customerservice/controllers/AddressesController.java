package com.etiyacrm.customerservice.controllers;

import com.etiyacrm.customerservice.core.business.paging.PageInfo;
import com.etiyacrm.customerservice.core.responses.GetListResponse;
import com.etiyacrm.customerservice.services.abstracts.AddressService;
import com.etiyacrm.customerservice.services.dtos.requests.addressRequests.CreateAddressRequest;
import com.etiyacrm.customerservice.services.dtos.requests.addressRequests.UpdateAddressRequest;
import com.etiyacrm.customerservice.services.dtos.responses.addressResponses.*;
import jakarta.validation.Valid;
import jakarta.ws.rs.Path;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin()
@RestController
@RequestMapping("api/v1/addresses")
@AllArgsConstructor
public class AddressesController {
    private AddressService addressService;

    @PostMapping
    public CreatedAddressResponse add(@Valid @RequestBody CreateAddressRequest createAddressRequest){
        return addressService.add(createAddressRequest);
    }

    @GetMapping()
    public GetListResponse<GetAllAddressResponse> getAll(@RequestParam int page, @RequestParam int size){
        return addressService.getAll(new PageInfo(page,size));
    }

    @GetMapping("/{id}")
    public GetAddressResponse getById(@PathVariable String id){
        return addressService.getById(id);
    }

    @PutMapping("/{id}")
    public UpdatedAddressResponse update(@Valid @RequestBody UpdateAddressRequest updateAddressRequest, @PathVariable String id){
        return addressService.update(updateAddressRequest, id);
    }

    @DeleteMapping("/{id}")
    public DeletedAddressResponse delete(@PathVariable String id) {
        return addressService.delete(id);
    }

    @GetMapping("/customerid/{customerId}")
    public List<GetAddressByCustomerIdResponse> getByCustomerId(@PathVariable String customerId){
        return addressService.getByCustomerId(customerId);
    }

}

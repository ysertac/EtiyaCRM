package com.etiyacrm.customerservice.controllers;

import com.etiyacrm.customerservice.services.abstracts.AddressBillingAccountService;
import com.etiyacrm.customerservice.services.dtos.requests.addressBillingAccountRequests.CreateAddressBillingAccountRequest;
import com.etiyacrm.customerservice.services.dtos.requests.addressBillingAccountRequests.UpdateAddressBillingAccountRequest;
import com.etiyacrm.customerservice.services.dtos.responses.addressBillingAccountResponses.*;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin()
@RestController
@RequestMapping("api/v1/addressbillingaccounts")
@AllArgsConstructor
public class AddressBillingAccountController {
    private AddressBillingAccountService addressBillingAccountService;

    @PostMapping
    public CreatedAddressBillingAccountResponse create(@RequestBody CreateAddressBillingAccountRequest createAddressBillingAccountRequest) {
        return addressBillingAccountService.create(createAddressBillingAccountRequest);
    }

    @GetMapping("/{id}")
    public GetAddressBillingAccountResponse getById(@PathVariable String id) {
        return addressBillingAccountService.getById(id);
    }

    @GetMapping("/addressid/{addressId}")
    public List<GetAddressBillingAccountResponseByAddressId> getByAddressId(@PathVariable String addressId) {
        return addressBillingAccountService.getByAddressId(addressId);
    }

    @GetMapping
    public List<GetAllAddressBillingAccountResponses> getAll() {
        return addressBillingAccountService.getAll();
    }

    @PutMapping("/{id}")
    public UpdatedAddressBillingAccountResponse update(@PathVariable String id,
                                                       @RequestBody UpdateAddressBillingAccountRequest updateAddressBillingAccountRequest) {
        return addressBillingAccountService.update(id, updateAddressBillingAccountRequest);
    }

    @DeleteMapping("/{id}")
    public DeletedAddressBillingAccountResponse delete(String id) {
        return addressBillingAccountService.delete(id);
    }
}

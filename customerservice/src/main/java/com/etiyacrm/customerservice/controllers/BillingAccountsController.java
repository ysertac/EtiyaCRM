package com.etiyacrm.customerservice.controllers;

import com.etiyacrm.customerservice.services.abstracts.BillingAccountService;
import com.etiyacrm.customerservice.services.dtos.requests.billingAccountRequests.CreateBillingAccountRequest;
import com.etiyacrm.customerservice.services.dtos.requests.billingAccountRequests.UpdateBillingAccountRequest;
import com.etiyacrm.customerservice.services.dtos.responses.billingAccountResponses.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin()
@RestController
@RequestMapping("api/v1/billing-accounts")
@AllArgsConstructor
public class BillingAccountsController {
    private BillingAccountService billingAccountService;

    @PostMapping
    public CreatedBillingAccountResponse add(@Valid @RequestBody CreateBillingAccountRequest createBillingAccountRequest) {
        return billingAccountService.add(createBillingAccountRequest);
    }

    @GetMapping()
    public List<GetAllBillingAccountResponse> getAll(){
        return billingAccountService.getAll();
    }

    @GetMapping("/{id}")
    public List<GetBillingAccountResponse> getByCustomerId(@PathVariable String id){
        return billingAccountService.getByCustomerId(id);
    }

    @PutMapping("/{id}")
    public UpdatedBillingAccountResponse update(@Valid @RequestBody UpdateBillingAccountRequest updateBillingAccountRequest, @PathVariable String id){
        return billingAccountService.update(updateBillingAccountRequest, id);
    }

    @DeleteMapping("/{id}")
    public DeletedBillingAccountResponse delete(@PathVariable String id) {
        return billingAccountService.delete(id);
    }

}

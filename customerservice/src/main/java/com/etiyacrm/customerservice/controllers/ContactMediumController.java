package com.etiyacrm.customerservice.controllers;

import com.etiyacrm.customerservice.services.abstracts.ContactMediumService;
import com.etiyacrm.customerservice.services.dtos.requests.contactMediumRequests.CreateContactMediumRequest;
import com.etiyacrm.customerservice.services.dtos.requests.contactMediumRequests.UpdateContactMediumRequest;
import com.etiyacrm.customerservice.services.dtos.requests.individualCustomerRequests.CreateIndividualCustomerRequest;
import com.etiyacrm.customerservice.services.dtos.requests.individualCustomerRequests.UpdateIndividualCustomerRequest;
import com.etiyacrm.customerservice.services.dtos.responses.IndividualCustomerResponses.*;
import com.etiyacrm.customerservice.services.dtos.responses.contactMediumResponses.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin()
@RestController
@RequestMapping("api/v1/contact-medium")
@AllArgsConstructor
public class ContactMediumController {
    private ContactMediumService contactMediumService;

    @PostMapping
    public CreatedContactMediumResponse add(@Valid @RequestBody CreateContactMediumRequest createContactMediumRequest) {
        return contactMediumService.add(createContactMediumRequest);
    }

    @GetMapping
    public List<GetAllContactMediumResponse> findAll() {
        return contactMediumService.findAll();
    }

    @GetMapping("/{id}")
    public GetContactMediumResponse findById(@PathVariable String id) {
        return contactMediumService.findById(id);
    }

    @GetMapping("/customerid/{customerId}")
    public GetContactMediumByCustomerIdResponse getByCustomerId(@PathVariable String customerId){
        return contactMediumService.getByCustomerId(customerId);
    }

    @PutMapping("/{id}")
    public UpdatedContactMediumResponse update(@Valid
            @RequestBody UpdateContactMediumRequest updateContactMediumRequest, @PathVariable String id) {
        return contactMediumService.update(updateContactMediumRequest, id);
    }

    @DeleteMapping("/{id}")
    public DeletedContactMediumResponse delete(@PathVariable String id) {
        return contactMediumService.delete(id);
    }
}

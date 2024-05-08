package com.etiyacrm.customerservice.controllers;

import com.etiyacrm.customerservice.services.abstracts.ContactMediumService;
import com.etiyacrm.customerservice.services.dtos.requests.contactMediumRequests.CreateContactMediumRequest;
import com.etiyacrm.customerservice.services.dtos.requests.contactMediumRequests.UpdateContactMediumRequest;
import com.etiyacrm.customerservice.services.dtos.requests.individualCustomerRequests.CreateIndividualCustomerRequest;
import com.etiyacrm.customerservice.services.dtos.requests.individualCustomerRequests.UpdateIndividualCustomerRequest;
import com.etiyacrm.customerservice.services.dtos.responses.IndividualCustomerResponses.*;
import com.etiyacrm.customerservice.services.dtos.responses.contactMediumResponses.*;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("customerservice/api/v1/contact-medium")
@AllArgsConstructor
public class ContactMediumController {
    private ContactMediumService contactMediumService;

    @PostMapping
    public CreatedContactMediumResponse add(@RequestBody CreateContactMediumRequest createContactMediumRequest) {
        return contactMediumService.add(createContactMediumRequest);
    }

    @GetMapping
    public List<GetAllContactMediumResponse> findAll() {
        return contactMediumService.findAll();
    }

    @GetMapping("/{id}")
    public GetContactMediumResponse findById(@PathVariable long id) {
        return contactMediumService.findById(id);
    }

    @PutMapping("/{id}")
    public UpdatedContactMediumResponse update(
            @RequestBody UpdateContactMediumRequest updateContactMediumRequest, @PathVariable long id) {
        return contactMediumService.update(updateContactMediumRequest, id);
    }

    @DeleteMapping("/{id}")
    public DeletedContactMediumResponse delete(@PathVariable long id) {
        return contactMediumService.delete(id);
    }
}

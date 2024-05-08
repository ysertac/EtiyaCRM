package com.etiyacrm.customerservice.controllers;

import com.etiyacrm.customerservice.services.abstracts.IndividualCustomerService;
import com.etiyacrm.customerservice.services.dtos.requests.individualCustomerRequests.CreateIndividualCustomerRequest;
import com.etiyacrm.customerservice.services.dtos.requests.individualCustomerRequests.UpdateIndividualCustomerRequest;
import com.etiyacrm.customerservice.services.dtos.responses.IndividualCustomerResponses.*;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("customerservice/api/v1/individualcustomers")
@AllArgsConstructor
public class IndividualCustomerController {
    private IndividualCustomerService individualCustomerService;

    @PostMapping
    public CreatedIndividualCustomerResponse add(@RequestBody CreateIndividualCustomerRequest createIndividualCustomerRequest) {
        return individualCustomerService.add(createIndividualCustomerRequest);
    }

    @GetMapping
    public List<GetAllIndividualCustomerResponse> findAll() {
        return individualCustomerService.findAll();
    }

    @GetMapping("/{id}")
    public GetIndividualCustomerResponse findById(@PathVariable long id) {
        return individualCustomerService.findById(id);
    }

    @PutMapping("/{id}")
    public UpdatedIndividualCustomerResponse update(
            @RequestBody UpdateIndividualCustomerRequest updateIndividualCustomerRequest, @PathVariable long id) {
        return individualCustomerService.update(updateIndividualCustomerRequest, id);
    }

    @DeleteMapping("/{id}")
    public DeletedIndividualCustomerResponse delete(@PathVariable long id) {
        return individualCustomerService.delete(id);
    }
}

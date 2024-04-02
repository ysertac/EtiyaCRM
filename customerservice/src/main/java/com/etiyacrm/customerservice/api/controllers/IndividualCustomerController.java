package com.etiyacrm.customerservice.api.controllers;

import com.etiyacrm.customerservice.business.abstracts.IndividualCustomerService;
import com.etiyacrm.customerservice.business.dtos.requests.IndividualCustomerRequests.CreateIndividualCustomerRequest;
import com.etiyacrm.customerservice.business.dtos.responses.IndividualCustomerResponses.CreateIndividualCustomerResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/individualcustomers")
@AllArgsConstructor
public class IndividualCustomerController {
    private IndividualCustomerService individualCustomerService;

    @PostMapping
    public CreateIndividualCustomerResponse add(@RequestBody CreateIndividualCustomerRequest createIndividualCustomerRequest) {
        return individualCustomerService.add(createIndividualCustomerRequest);
    }
}

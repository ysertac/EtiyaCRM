package com.etiyacrm.customerservice.business.abstracts;

import com.etiyacrm.customerservice.business.dtos.requests.IndividualCustomerRequests.CreateIndividualCustomerRequest;
import com.etiyacrm.customerservice.business.dtos.responses.IndividualCustomerResponses.CreateIndividualCustomerResponse;

public interface IndividualCustomerService {
    CreateIndividualCustomerResponse add(CreateIndividualCustomerRequest createIndividualCustomerRequest);
}

package com.etiyacrm.customerservice.services.abstracts;

import com.etiyacrm.customerservice.services.dtos.requests.individualCustomerRequests.CreateIndividualCustomerRequest;
import com.etiyacrm.customerservice.services.dtos.requests.individualCustomerRequests.UpdateIndividualCustomerRequest;
import com.etiyacrm.customerservice.services.dtos.responses.IndividualCustomerResponses.*;

import java.util.List;

public interface IndividualCustomerService {
    CreatedIndividualCustomerResponse add(CreateIndividualCustomerRequest createIndividualCustomerRequest);
    List<GetAllIndividualCustomerResponse> findAll();
    GetIndividualCustomerResponse findById(long id);
    UpdatedIndividualCustomerResponse update(UpdateIndividualCustomerRequest updateIndividualCustomerRequest, long id);
    DeletedIndividualCustomerResponse delete(long id);
}

package com.etiyacrm.customerservice.services.abstracts;

import com.etiyacrm.customerservice.services.dtos.requests.contactMediumRequests.CreateContactMediumRequest;
import com.etiyacrm.customerservice.services.dtos.requests.contactMediumRequests.UpdateContactMediumRequest;
import com.etiyacrm.customerservice.services.dtos.responses.IndividualCustomerResponses.DeletedIndividualCustomerResponse;
import com.etiyacrm.customerservice.services.dtos.responses.IndividualCustomerResponses.UpdatedIndividualCustomerResponse;
import com.etiyacrm.customerservice.services.dtos.responses.contactMediumResponses.*;

import java.util.List;

public interface ContactMediumService {
    CreatedContactMediumResponse add(CreateContactMediumRequest createContactMediumRequest);

    List<GetAllContactMediumResponse> findAll();

    GetContactMediumResponse findById(String id);

    GetContactMediumByCustomerIdResponse getByCustomerId(String customerId);

    UpdatedContactMediumResponse update(UpdateContactMediumRequest updateContactMediumRequest, String id);

    DeletedContactMediumResponse delete(String id);
}

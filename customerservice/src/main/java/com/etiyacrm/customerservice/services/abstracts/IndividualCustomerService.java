package com.etiyacrm.customerservice.services.abstracts;

import com.etiyacrm.customerservice.services.dtos.requests.individualCustomerRequests.CheckTurkishCitizenRequest;
import com.etiyacrm.customerservice.services.dtos.requests.individualCustomerRequests.CreateIndividualCustomerRequest;
import com.etiyacrm.customerservice.services.dtos.requests.individualCustomerRequests.UpdateIndividualCustomerRequest;
import com.etiyacrm.customerservice.services.dtos.responses.IndividualCustomerResponses.*;

import java.util.List;

public interface IndividualCustomerService {
    CreatedIndividualCustomerResponse add(CreateIndividualCustomerRequest createIndividualCustomerRequest) throws Exception;
    List<GetAllIndividualCustomerResponse> findAll();
    GetIndividualCustomerResponse findById(String id);
    boolean isIndividualCustomerExistsByNationalityId(String nationalityId);
    UpdatedIndividualCustomerResponse update(UpdateIndividualCustomerRequest updateIndividualCustomerRequest, String id) throws Exception;
    DeletedIndividualCustomerResponse delete(String id);
    boolean checkIfTurkishCitizen(CheckTurkishCitizenRequest checkTurkishCitizenRequest) throws Exception;
}

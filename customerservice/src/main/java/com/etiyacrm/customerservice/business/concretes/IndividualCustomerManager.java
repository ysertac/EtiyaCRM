package com.etiyacrm.customerservice.business.concretes;

import com.etiyacrm.customerservice.business.abstracts.IndividualCustomerService;
import com.etiyacrm.customerservice.business.dtos.requests.IndividualCustomerRequests.CreateIndividualCustomerRequest;
import com.etiyacrm.customerservice.business.dtos.responses.IndividualCustomerResponses.CreateIndividualCustomerResponse;
import com.etiyacrm.customerservice.core.utilities.mapping.ModelMapperService;
import com.etiyacrm.customerservice.dataAccess.abstracts.IndividualCustomerRepository;
import com.etiyacrm.customerservice.entities.Customer;
import com.etiyacrm.customerservice.entities.IndividualCustomer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class IndividualCustomerManager implements IndividualCustomerService {
    private IndividualCustomerRepository individualCustomerRepository;
    private ModelMapperService modelMapperService;

    @Override
    public CreateIndividualCustomerResponse add(CreateIndividualCustomerRequest createIndividualCustomerRequest) {
        Customer customer = new Customer();
        customer.setEmail(createIndividualCustomerRequest.getEmail());

        IndividualCustomer mappedIndividualCustomer = modelMapperService
                .forRequest().map(createIndividualCustomerRequest, IndividualCustomer.class);
        mappedIndividualCustomer.setCustomer(customer);

        IndividualCustomer createdCustomer = individualCustomerRepository.save(mappedIndividualCustomer);

        CreateIndividualCustomerResponse createIndividualCustomerResponse =
                modelMapperService.forResponse().map(createdCustomer, CreateIndividualCustomerResponse.class);
        return createIndividualCustomerResponse;
    }
}

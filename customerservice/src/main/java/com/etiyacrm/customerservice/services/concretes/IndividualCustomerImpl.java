package com.etiyacrm.customerservice.services.concretes;


import com.etiya.common.events.CustomerCreatedEvent;
import com.etiyacrm.customerservice.entities.Customer;
import com.etiyacrm.customerservice.entities.IndividualCustomer;
import com.etiyacrm.customerservice.kafka.producers.CustomerProducer;
import com.etiyacrm.customerservice.repositories.IndividualCustomerRepository;
import com.etiyacrm.customerservice.services.abstracts.IndividualCustomerService;
import com.etiyacrm.customerservice.services.dtos.requests.individualCustomerRequests.CreateIndividualCustomerRequest;
import com.etiyacrm.customerservice.services.dtos.requests.individualCustomerRequests.UpdateIndividualCustomerRequest;
import com.etiyacrm.customerservice.services.dtos.responses.IndividualCustomerResponses.*;
import com.etiyacrm.customerservice.services.mappers.IndividualCustomerMapper;
import com.etiyacrm.customerservice.services.rules.IndividualCustomerBusinessRules;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class IndividualCustomerImpl implements IndividualCustomerService {
    private IndividualCustomerRepository individualCustomerRepository;
    private IndividualCustomerBusinessRules individualCustomerBusinessRules;
    private CustomerProducer customerProducer;

    @Override
    public CreatedIndividualCustomerResponse add(CreateIndividualCustomerRequest createIndividualCustomerRequest) {
        individualCustomerBusinessRules.individualCustomerNationalityIdCannotBeDuplicated(createIndividualCustomerRequest.getNationalityId());

        Customer customer = new Customer();
        customer.setCreatedDate(LocalDateTime.now());

        IndividualCustomer individualCustomer =
                IndividualCustomerMapper.INSTANCE.individualCustomerFromCreateIndividualCustomerRequest(createIndividualCustomerRequest);
        individualCustomer.setCustomer(customer);

        IndividualCustomer createdCustomer = individualCustomerRepository.save(individualCustomer);

        CreatedIndividualCustomerResponse createdIndividualCustomerResponse =
                IndividualCustomerMapper.INSTANCE.createdIndividualCustomerResponseFromIndividualCustomer(createdCustomer);
        CustomerCreatedEvent customerCreatedEvent =
                new CustomerCreatedEvent(createdIndividualCustomerResponse.getId(), createdIndividualCustomerResponse.getFirstName());
        customerProducer.sendMessage(customerCreatedEvent);
        return createdIndividualCustomerResponse;
    }

    @Override
    public List<GetAllIndividualCustomerResponse> findAll() {
        List<IndividualCustomer> allIndividualCustomers = individualCustomerRepository.findAll();
        List<GetAllIndividualCustomerResponse> getAllIndividualCustomerResponses = allIndividualCustomers.stream()
                .filter(individualCustomer -> individualCustomer.getCustomer().getDeletedDate() == null)
                .map(individualCustomer ->
                        IndividualCustomerMapper.INSTANCE
                                .getAllIndividualCustomerResponseFromIndividualCustomer(individualCustomer)).collect(Collectors.toList());
        return getAllIndividualCustomerResponses;
    }

    @Override
    public GetIndividualCustomerResponse findById(long id) {
        individualCustomerBusinessRules.individualCustomerIdMustExist(id);
        //individualCustomerBusinessRules.deletedIndividualCustomer(id);

        IndividualCustomer foundIndividualCustomer = individualCustomerRepository.findById(id).get();

        return IndividualCustomerMapper.INSTANCE.getIndividualCustomerFromIndividualCustomer(foundIndividualCustomer);
    }

    @Override
    public UpdatedIndividualCustomerResponse update(UpdateIndividualCustomerRequest updateIndividualCustomerRequest, long id) {
        //individualCustomerBusinessRules.deletedIndividualCustomer(id);
        individualCustomerBusinessRules.individualCustomerIdMustExist(id);

        IndividualCustomer foundIndividualCustomer = individualCustomerRepository.findById(id).get();
        IndividualCustomer individualCustomer =
                IndividualCustomerMapper.INSTANCE.individualCustomerFromUpdateIndividualCustomerRequest(updateIndividualCustomerRequest);

        individualCustomer.setId(id);
        individualCustomer.setCustomer(foundIndividualCustomer.getCustomer());
        individualCustomer.getCustomer().setUpdatedDate(LocalDateTime.now());
        IndividualCustomer updatedIndividualCustomer = individualCustomerRepository.save(individualCustomer);

        return IndividualCustomerMapper.INSTANCE.updatedIndividualCustomerResponseFromIndividualCustomer(updatedIndividualCustomer);
    }

    @Override
    public DeletedIndividualCustomerResponse delete(long id) {
        individualCustomerBusinessRules.individualCustomerIdMustExist(id);
        //individualCustomerBusinessRules.deletedIndividualCustomer(id);

        IndividualCustomer foundIndividualCustomer = individualCustomerRepository.findById(id).get();
        foundIndividualCustomer.getCustomer().setId(id);
        foundIndividualCustomer.getCustomer().setDeletedDate(LocalDateTime.now());

        IndividualCustomer deletedIndividualCustomer = individualCustomerRepository.save(foundIndividualCustomer);

        return IndividualCustomerMapper.INSTANCE.deleteIndividualCustomerResponseFromIndividualCustomer(deletedIndividualCustomer);
    }
}

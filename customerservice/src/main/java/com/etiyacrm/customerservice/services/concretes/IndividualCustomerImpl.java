package com.etiyacrm.customerservice.services.concretes;


import com.etiya.common.events.CustomerDeletedEvent;
import com.etiya.common.events.CustomerUpdatedEvent;
import com.etiyacrm.customerservice.adapters.CustomerCheckService;
import com.etiyacrm.customerservice.entities.Address;
import com.etiyacrm.customerservice.entities.Customer;
import com.etiyacrm.customerservice.entities.IndividualCustomer;
import com.etiyacrm.customerservice.kafka.producers.CustomerDeletedProducer;
import com.etiyacrm.customerservice.kafka.producers.CustomerUpdatedProducer;
import com.etiyacrm.customerservice.repositories.IndividualCustomerRepository;
import com.etiyacrm.customerservice.services.abstracts.IndividualCustomerService;
import com.etiyacrm.customerservice.services.dtos.requests.individualCustomerRequests.CheckTurkishCitizenRequest;
import com.etiyacrm.customerservice.services.dtos.requests.individualCustomerRequests.CreateIndividualCustomerRequest;
import com.etiyacrm.customerservice.services.dtos.requests.individualCustomerRequests.UpdateIndividualCustomerRequest;
import com.etiyacrm.customerservice.services.dtos.responses.IndividualCustomerResponses.*;
import com.etiyacrm.customerservice.services.mappers.IndividualCustomerMapper;
import com.etiyacrm.customerservice.services.rules.IndividualCustomerBusinessRules;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class IndividualCustomerImpl implements IndividualCustomerService {
    private IndividualCustomerRepository individualCustomerRepository;
    private IndividualCustomerBusinessRules individualCustomerBusinessRules;
    private CustomerCheckService customerCheckService;
    private CustomerUpdatedProducer customerUpdatedProducer;
    private CustomerDeletedProducer customerDeletedProducer;

    @Override
    public CreatedIndividualCustomerResponse add(CreateIndividualCustomerRequest createIndividualCustomerRequest) throws Exception {
        String fullName = createIndividualCustomerRequest.getFirstName();
        if (!createIndividualCustomerRequest.getMiddleName().isEmpty()) {
            fullName += " " + createIndividualCustomerRequest.getMiddleName();
        }
        individualCustomerBusinessRules.checkIdNationalIdentityExists(createIndividualCustomerRequest.getNationalityId(),
                fullName,
                createIndividualCustomerRequest.getLastName(),
                createIndividualCustomerRequest.getBirthDate().getYear());
        individualCustomerBusinessRules.individualCustomerNationalityIdCannotBeDuplicated(createIndividualCustomerRequest.getNationalityId());
        final String customerId = UUID.randomUUID().toString();
        Customer customer = new Customer();
        customer.setId(customerId);
        customer.setCustomerNumber((int) (Math.random() * 1000000));
        customer.setCreatedDate(LocalDateTime.now());

        IndividualCustomer individualCustomer =
                IndividualCustomerMapper.INSTANCE.individualCustomerFromCreateIndividualCustomerRequest(createIndividualCustomerRequest);
        individualCustomer.setCustomer(customer);
        individualCustomer.setId(customerId);
        IndividualCustomer createdCustomer = individualCustomerRepository.save(individualCustomer);

        CreatedIndividualCustomerResponse createdIndividualCustomerResponse =
                IndividualCustomerMapper.INSTANCE.createdIndividualCustomerResponseFromIndividualCustomer(createdCustomer);
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
    public boolean isIndividualCustomerExistsByNationalityId(String nationalityId) {
        Optional<IndividualCustomer> individualCustomer = individualCustomerRepository.findByNationalityIdAndDeletedDateIsNull(nationalityId);
        if (individualCustomer.isPresent()) {
            return true;
        }
        return false;
    }

    @Override
    public GetIndividualCustomerResponse findById(String id) {
        individualCustomerBusinessRules.individualCustomerIdMustExist(id);

        IndividualCustomer foundIndividualCustomer = individualCustomerRepository.findById(id).get();

        return IndividualCustomerMapper.INSTANCE.getIndividualCustomerFromIndividualCustomer(foundIndividualCustomer);
    }

    @Override
    public UpdatedIndividualCustomerResponse update(UpdateIndividualCustomerRequest updateIndividualCustomerRequest, String id) throws Exception{
        individualCustomerBusinessRules.individualCustomerIdMustExist(id);
        individualCustomerBusinessRules.individualCustomerNationalityIdIsExist(id,updateIndividualCustomerRequest.getNationalityId());
        String fullName = updateIndividualCustomerRequest.getFirstName();
        if (!updateIndividualCustomerRequest.getMiddleName().isEmpty()) {
            fullName += " " + updateIndividualCustomerRequest.getMiddleName();
        }
        individualCustomerBusinessRules.checkIdNationalIdentityExists(updateIndividualCustomerRequest.getNationalityId(),
                fullName,
                updateIndividualCustomerRequest.getLastName(),
                updateIndividualCustomerRequest.getBirthDate().getYear());

        IndividualCustomer foundIndividualCustomer = individualCustomerRepository.findById(id).get();
        IndividualCustomer individualCustomer =
                IndividualCustomerMapper.INSTANCE.individualCustomerFromUpdateIndividualCustomerRequest(updateIndividualCustomerRequest);

        individualCustomer.setId(id);
        individualCustomer.setCustomer(foundIndividualCustomer.getCustomer());
        individualCustomer.getCustomer().setUpdatedDate(LocalDateTime.now());
        IndividualCustomer updatedIndividualCustomer = individualCustomerRepository.save(individualCustomer);

        CustomerUpdatedEvent customerUpdatedEvent = new CustomerUpdatedEvent();
        customerUpdatedEvent.setCustomerId(updatedIndividualCustomer.getId());
        customerUpdatedEvent.setFirstName(updatedIndividualCustomer.getFirstName());
        customerUpdatedEvent.setMiddleName(updatedIndividualCustomer.getMiddleName());
        customerUpdatedEvent.setLastname(updatedIndividualCustomer.getLastName());
        customerUpdatedEvent.setNationalityId(updatedIndividualCustomer.getNationalityId());
        customerUpdatedProducer.sendMessage(customerUpdatedEvent);
        return IndividualCustomerMapper.INSTANCE.updatedIndividualCustomerResponseFromIndividualCustomer(updatedIndividualCustomer);
    }

    @Override
    public DeletedIndividualCustomerResponse delete(String id) {
        individualCustomerBusinessRules.individualCustomerIdMustExist(id);
        //individualCustomerBusinessRules.deletedIndividualCustomer(id);

        IndividualCustomer foundIndividualCustomer = individualCustomerRepository.findById(id).get();
        foundIndividualCustomer.getCustomer().setId(id);
        List<Address> addresses = foundIndividualCustomer.getCustomer().getAddresses();
        for (Address address :addresses) {
            address.setDeletedDate(LocalDateTime.now());
        }
        foundIndividualCustomer.getCustomer().getContactMedium().setDeletedDate(LocalDateTime.now());
        foundIndividualCustomer.getCustomer().setDeletedDate(LocalDateTime.now());

        IndividualCustomer deletedIndividualCustomer = individualCustomerRepository.save(foundIndividualCustomer);
        CustomerDeletedEvent customerDeletedEvent = new CustomerDeletedEvent();
        customerDeletedEvent.setCustomerId(deletedIndividualCustomer.getId());
        customerDeletedProducer.sendMessage(customerDeletedEvent);

        return IndividualCustomerMapper.INSTANCE.deleteIndividualCustomerResponseFromIndividualCustomer(deletedIndividualCustomer);
    }

    @Override
    public boolean checkIfTurkishCitizen(CheckTurkishCitizenRequest checkTurkishCitizenRequest) throws Exception {
        return customerCheckService.checkIfRealPerson(checkTurkishCitizenRequest.getNationalityId(), checkTurkishCitizenRequest.getFirstName(),
                checkTurkishCitizenRequest.getLastName(), checkTurkishCitizenRequest.getBirthDate().getYear());
    }
}

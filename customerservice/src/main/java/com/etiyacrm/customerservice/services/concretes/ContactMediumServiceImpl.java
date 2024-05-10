package com.etiyacrm.customerservice.services.concretes;

import com.etiya.common.events.CustomerCreatedEvent;
import com.etiyacrm.customerservice.entities.ContactMedium;
import com.etiyacrm.customerservice.entities.Customer;
import com.etiyacrm.customerservice.entities.IndividualCustomer;
import com.etiyacrm.customerservice.kafka.producers.CustomerCreatedProducer;
import com.etiyacrm.customerservice.repositories.ContactMediumRepository;
import com.etiyacrm.customerservice.services.abstracts.ContactMediumService;
import com.etiyacrm.customerservice.services.abstracts.IndividualCustomerService;
import com.etiyacrm.customerservice.services.dtos.requests.contactMediumRequests.CreateContactMediumRequest;
import com.etiyacrm.customerservice.services.dtos.requests.contactMediumRequests.UpdateContactMediumRequest;
import com.etiyacrm.customerservice.services.dtos.responses.IndividualCustomerResponses.GetIndividualCustomerResponse;
import com.etiyacrm.customerservice.services.dtos.responses.contactMediumResponses.*;
import com.etiyacrm.customerservice.services.mappers.ContactMediumMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ContactMediumServiceImpl implements ContactMediumService {
    private ContactMediumRepository contactMediumRepository;
    private IndividualCustomerService individualCustomerService;
    private CustomerCreatedProducer customerCreatedProducer;

    @Override
    public CreatedContactMediumResponse add(CreateContactMediumRequest createContactMediumRequest) {
        ContactMedium contactMedium =
                ContactMediumMapper.INSTANCE.contactMediumFromCreateContactMediumRequest(createContactMediumRequest);
        contactMedium.setId(UUID.randomUUID().toString());
        contactMedium.setCreatedDate(LocalDateTime.now());
        ContactMedium savedContactMedium = this.contactMediumRepository.save(contactMedium);

        GetIndividualCustomerResponse individualCustomer = individualCustomerService.findById(createContactMediumRequest.getCustomerId());

        CustomerCreatedEvent customerCreatedEvent = new CustomerCreatedEvent();
        customerCreatedEvent.setCustomerId(createContactMediumRequest.getCustomerId());
        customerCreatedEvent.setFirstName(individualCustomer.getFirstName());
        customerCreatedEvent.setMiddleName(individualCustomer.getMiddleName());
        customerCreatedEvent.setLastname(individualCustomer.getLastName());
        customerCreatedEvent.setNationalityId(individualCustomer.getNationalityId());
        customerCreatedEvent.setMobilePhone(createContactMediumRequest.getMobilePhone());
        customerCreatedProducer.sendMessage(customerCreatedEvent);

        return ContactMediumMapper.INSTANCE.createdContactMediumResponseFromContactMedium(savedContactMedium);
    }

    @Override
    public List<GetAllContactMediumResponse> findAll() {
        List<ContactMedium> contactMediumsList = this.contactMediumRepository.findAll();
        List<GetAllContactMediumResponse> getAllContactMediumResponses = contactMediumsList.stream()
                .filter(contactMedium -> contactMedium.getDeletedDate() == null)
                .map(contactMedium ->
                        ContactMediumMapper.INSTANCE
                                .getAllContactMediumResponseFromContactMedium(contactMedium)).collect(Collectors.toList());
        return getAllContactMediumResponses;
    }

    @Override
    public GetContactMediumResponse findById(String id) {
        ContactMedium contactMedium = this.contactMediumRepository.findById(id).get();
        return ContactMediumMapper.INSTANCE.getContactMediumResponseFromContactMedium(contactMedium);
    }

    @Override
    public UpdatedContactMediumResponse update(UpdateContactMediumRequest updateContactMediumRequest, String id) {
        ContactMedium contactMediumFromDb = this.contactMediumRepository.findById(id).get();
        ContactMedium contactMedium = ContactMediumMapper.INSTANCE.contactMediumFromUpdateContactMediumRequest(updateContactMediumRequest);
        contactMedium.setId(id);
        Customer customer = new Customer();
        customer.setId(contactMedium.getCustomer().getId());
        contactMedium.setCustomer(customer);
        contactMedium.setUpdatedDate(LocalDateTime.now());
        contactMedium.setCreatedDate(contactMediumFromDb.getCreatedDate());
        ContactMedium updatedContactMedium = this.contactMediumRepository.save(contactMedium);

        return ContactMediumMapper.INSTANCE.updatedContactMediumResponseFromContactMedium(updatedContactMedium);
    }

    @Override
    public DeletedContactMediumResponse delete(String id) {
        ContactMedium contactMedium = this.contactMediumRepository.findById(id).get();
        contactMedium.setDeletedDate(LocalDateTime.now());
        ContactMedium savedContactMedium = this.contactMediumRepository.save(contactMedium);
        return ContactMediumMapper.INSTANCE.deletedContactMediumResponseFromContactMedium(savedContactMedium);
    }
}

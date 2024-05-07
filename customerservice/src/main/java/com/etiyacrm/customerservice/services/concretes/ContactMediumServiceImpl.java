package com.etiyacrm.customerservice.services.concretes;

import com.etiyacrm.customerservice.entities.ContactMedium;
import com.etiyacrm.customerservice.repositories.ContactMediumRepository;
import com.etiyacrm.customerservice.services.abstracts.ContactMediumService;
import com.etiyacrm.customerservice.services.dtos.requests.contactMediumRequests.CreateContactMediumRequest;
import com.etiyacrm.customerservice.services.dtos.requests.contactMediumRequests.UpdateContactMediumRequest;
import com.etiyacrm.customerservice.services.dtos.responses.IndividualCustomerResponses.DeletedIndividualCustomerResponse;
import com.etiyacrm.customerservice.services.dtos.responses.IndividualCustomerResponses.GetAllIndividualCustomerResponse;
import com.etiyacrm.customerservice.services.dtos.responses.IndividualCustomerResponses.UpdatedIndividualCustomerResponse;
import com.etiyacrm.customerservice.services.dtos.responses.contactMediumResponses.*;
import com.etiyacrm.customerservice.services.mappers.CityMapper;
import com.etiyacrm.customerservice.services.mappers.ContactMediumMapper;
import com.etiyacrm.customerservice.services.mappers.IndividualCustomerMapper;
import lombok.AllArgsConstructor;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ContactMediumServiceImpl implements ContactMediumService {
    private ContactMediumRepository contactMediumRepository;
    @Override
    public CreatedContactMediumResponse add(CreateContactMediumRequest createContactMediumRequest) {
        ContactMedium contactMedium = ContactMediumMapper.INSTANCE.contactMediumFromCreateContactMediumRequest(createContactMediumRequest);
        contactMedium.setCreatedDate(LocalDateTime.now());
        ContactMedium savedContactMedium = this.contactMediumRepository.save(contactMedium);
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
    public GetContactMediumResponse findById(long id) {
        ContactMedium contactMedium = this.contactMediumRepository.findById(id).get();
        return ContactMediumMapper.INSTANCE.getContactMediumResponseFromContactMedium(contactMedium);
    }

    @Override
    public UpdatedContactMediumResponse update(UpdateContactMediumRequest updateContactMediumRequest, long id) {
        ContactMedium contactMediumFromDb = this.contactMediumRepository.findById(id).get();
        ContactMedium contactMedium  = ContactMediumMapper.INSTANCE.contactMediumFromUpdateContactMediumRequest(updateContactMediumRequest);
        contactMedium.setId(id);
        contactMedium.setUpdatedDate(LocalDateTime.now());
        contactMedium.setCreatedDate(contactMediumFromDb.getCreatedDate());
        ContactMedium updatedContactMedium = this.contactMediumRepository.save(contactMedium);

        return ContactMediumMapper.INSTANCE.updatedContactMediumResponseFromContactMedium(updatedContactMedium);
    }

    @Override
    public DeletedContactMediumResponse delete(long id) {
        ContactMedium contactMedium = this.contactMediumRepository.findById(id).get();
        contactMedium.setDeletedDate(LocalDateTime.now());
        ContactMedium savedContactMedium = this.contactMediumRepository.save(contactMedium);
        return ContactMediumMapper.INSTANCE.deletedContactMediumResponseFromContactMedium(savedContactMedium);
    }
}

package com.etiyacrm.customerservice.services.mappers;

import com.etiyacrm.customerservice.entities.City;
import com.etiyacrm.customerservice.entities.ContactMedium;
import com.etiyacrm.customerservice.services.dtos.requests.cityRequests.CreateCityRequest;
import com.etiyacrm.customerservice.services.dtos.requests.cityRequests.UpdateCityRequest;
import com.etiyacrm.customerservice.services.dtos.requests.contactMediumRequests.CreateContactMediumRequest;
import com.etiyacrm.customerservice.services.dtos.requests.contactMediumRequests.UpdateContactMediumRequest;
import com.etiyacrm.customerservice.services.dtos.responses.CityResponses.*;
import com.etiyacrm.customerservice.services.dtos.responses.contactMediumResponses.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ContactMediumMapper {
    ContactMediumMapper INSTANCE = Mappers.getMapper(ContactMediumMapper.class);
    @Mapping(source = "contactMedium.customer.id", target = "customerId")
    GetAllContactMediumResponse getAllContactMediumResponseFromContactMedium(ContactMedium contactMedium);
    @Mapping(source = "createContactMediumRequest.customerId", target = "customer.id")
    ContactMedium contactMediumFromCreateContactMediumRequest(CreateContactMediumRequest createContactMediumRequest);
    @Mapping(source = "contactMedium.customer.id", target = "customerId")
    CreatedContactMediumResponse createdContactMediumResponseFromContactMedium(ContactMedium contactMedium);
    @Mapping(source = "contactMedium.customer.id", target = "customerId")
    GetContactMediumByCustomerIdResponse getContactMediumByCustomerIdResponseFromContactMedium(ContactMedium contactMedium);
    @Mapping(source = "contactMedium.customer.id", target = "customerId")
    GetContactMediumResponse getContactMediumResponseFromContactMedium(ContactMedium contactMedium);
    @Mapping(source = "updateContactMediumRequest.customerId", target = "customer.id")
    ContactMedium contactMediumFromUpdateContactMediumRequest(UpdateContactMediumRequest updateContactMediumRequest);
    @Mapping(source = "contactMedium.customer.id", target = "customerId")
    UpdatedContactMediumResponse updatedContactMediumResponseFromContactMedium(ContactMedium contactMedium);
    @Mapping(source = "contactMedium.customer.id", target = "customerId")
    DeletedContactMediumResponse deletedContactMediumResponseFromContactMedium(ContactMedium contactMedium);
}

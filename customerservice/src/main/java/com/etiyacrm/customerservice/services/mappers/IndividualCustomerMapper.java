package com.etiyacrm.customerservice.services.mappers;

import com.etiyacrm.customerservice.entities.IndividualCustomer;
import com.etiyacrm.customerservice.services.dtos.requests.individualCustomerRequests.CreateIndividualCustomerRequest;
import com.etiyacrm.customerservice.services.dtos.requests.individualCustomerRequests.UpdateIndividualCustomerRequest;
import com.etiyacrm.customerservice.services.dtos.responses.IndividualCustomerResponses.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface IndividualCustomerMapper {
    IndividualCustomerMapper INSTANCE = Mappers.getMapper(IndividualCustomerMapper.class);

    @Mapping(source = "individualCustomer.customer.email", target = "email")
    GetAllIndividualCustomerResponse getAllIndividualCustomerResponseFromIndividualCustomer(IndividualCustomer individualCustomer);

    @Mapping(source = "individualCustomer.customer.email", target = "email")
    GetIndividualCustomerResponse getIndividualCustomerFromIndividualCustomer(IndividualCustomer individualCustomer);

    IndividualCustomer individualCustomerFromCreateIndividualCustomerRequest(CreateIndividualCustomerRequest createIndividualCustomerRequest);

    IndividualCustomer individualCustomerFromUpdateIndividualCustomerRequest(UpdateIndividualCustomerRequest updateIndividualCustomerRequest);

    @Mapping(source = "individualCustomer.customer.email", target = "email")
    CreatedIndividualCustomerResponse createdIndividualCustomerResponseFromIndividualCustomer(IndividualCustomer individualCustomer);

    @Mapping(source = "individualCustomer.customer.email", target = "email")
    UpdatedIndividualCustomerResponse updatedIndividualCustomerResponseFromIndividualCustomer(IndividualCustomer individualCustomer);

    @Mapping(source = "individualCustomer.customer.email", target = "email")
    DeletedIndividualCustomerResponse deleteIndividualCustomerResponseFromIndividualCustomer(IndividualCustomer individualCustomer);
}

package com.etiyacrm.customerservice.services.mappers;

import com.etiyacrm.customerservice.entities.Customer;
import com.etiyacrm.customerservice.entities.IndividualCustomer;
import com.etiyacrm.customerservice.services.dtos.requests.individualCustomerRequests.CreateIndividualCustomerRequest;
import com.etiyacrm.customerservice.services.dtos.requests.individualCustomerRequests.UpdateIndividualCustomerRequest;
import com.etiyacrm.customerservice.services.dtos.responses.IndividualCustomerResponses.CreatedIndividualCustomerResponse;
import com.etiyacrm.customerservice.services.dtos.responses.IndividualCustomerResponses.DeletedIndividualCustomerResponse;
import com.etiyacrm.customerservice.services.dtos.responses.IndividualCustomerResponses.GetAllIndividualCustomerResponse;
import com.etiyacrm.customerservice.services.dtos.responses.IndividualCustomerResponses.GetIndividualCustomerResponse;
import com.etiyacrm.customerservice.services.dtos.responses.IndividualCustomerResponses.UpdatedIndividualCustomerResponse;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-05T00:25:58-0700",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.10 (Amazon.com Inc.)"
)
public class IndividualCustomerMapperImpl implements IndividualCustomerMapper {

    @Override
    public GetAllIndividualCustomerResponse getAllIndividualCustomerResponseFromIndividualCustomer(IndividualCustomer individualCustomer) {
        if ( individualCustomer == null ) {
            return null;
        }

        GetAllIndividualCustomerResponse getAllIndividualCustomerResponse = new GetAllIndividualCustomerResponse();

        getAllIndividualCustomerResponse.setEmail( individualCustomerCustomerEmail( individualCustomer ) );
        getAllIndividualCustomerResponse.setId( individualCustomer.getId() );
        getAllIndividualCustomerResponse.setFirstName( individualCustomer.getFirstName() );
        getAllIndividualCustomerResponse.setMiddleName( individualCustomer.getMiddleName() );
        getAllIndividualCustomerResponse.setLastName( individualCustomer.getLastName() );
        getAllIndividualCustomerResponse.setGender( individualCustomer.getGender() );
        getAllIndividualCustomerResponse.setMotherName( individualCustomer.getMotherName() );
        getAllIndividualCustomerResponse.setFatherName( individualCustomer.getFatherName() );
        getAllIndividualCustomerResponse.setNationalityId( individualCustomer.getNationalityId() );
        getAllIndividualCustomerResponse.setBirthDate( individualCustomer.getBirthDate() );

        return getAllIndividualCustomerResponse;
    }

    @Override
    public GetIndividualCustomerResponse getIndividualCustomerFromIndividualCustomer(IndividualCustomer individualCustomer) {
        if ( individualCustomer == null ) {
            return null;
        }

        GetIndividualCustomerResponse getIndividualCustomerResponse = new GetIndividualCustomerResponse();

        getIndividualCustomerResponse.setEmail( individualCustomerCustomerEmail( individualCustomer ) );
        getIndividualCustomerResponse.setId( individualCustomer.getId() );
        getIndividualCustomerResponse.setFirstName( individualCustomer.getFirstName() );
        getIndividualCustomerResponse.setMiddleName( individualCustomer.getMiddleName() );
        getIndividualCustomerResponse.setLastName( individualCustomer.getLastName() );
        getIndividualCustomerResponse.setGender( individualCustomer.getGender() );
        getIndividualCustomerResponse.setMotherName( individualCustomer.getMotherName() );
        getIndividualCustomerResponse.setFatherName( individualCustomer.getFatherName() );
        getIndividualCustomerResponse.setNationalityId( individualCustomer.getNationalityId() );
        getIndividualCustomerResponse.setBirthDate( individualCustomer.getBirthDate() );

        return getIndividualCustomerResponse;
    }

    @Override
    public IndividualCustomer individualCustomerFromCreateIndividualCustomerRequest(CreateIndividualCustomerRequest createIndividualCustomerRequest) {
        if ( createIndividualCustomerRequest == null ) {
            return null;
        }

        IndividualCustomer individualCustomer = new IndividualCustomer();

        individualCustomer.setFirstName( createIndividualCustomerRequest.getFirstName() );
        individualCustomer.setMiddleName( createIndividualCustomerRequest.getMiddleName() );
        individualCustomer.setLastName( createIndividualCustomerRequest.getLastName() );
        individualCustomer.setGender( createIndividualCustomerRequest.getGender() );
        individualCustomer.setMotherName( createIndividualCustomerRequest.getMotherName() );
        individualCustomer.setFatherName( createIndividualCustomerRequest.getFatherName() );
        individualCustomer.setNationalityId( createIndividualCustomerRequest.getNationalityId() );
        individualCustomer.setBirthDate( createIndividualCustomerRequest.getBirthDate() );

        return individualCustomer;
    }

    @Override
    public IndividualCustomer individualCustomerFromUpdateIndividualCustomerRequest(UpdateIndividualCustomerRequest updateIndividualCustomerRequest) {
        if ( updateIndividualCustomerRequest == null ) {
            return null;
        }

        IndividualCustomer individualCustomer = new IndividualCustomer();

        individualCustomer.setFirstName( updateIndividualCustomerRequest.getFirstName() );
        individualCustomer.setMiddleName( updateIndividualCustomerRequest.getMiddleName() );
        individualCustomer.setLastName( updateIndividualCustomerRequest.getLastName() );
        individualCustomer.setGender( updateIndividualCustomerRequest.getGender() );
        individualCustomer.setMotherName( updateIndividualCustomerRequest.getMotherName() );
        individualCustomer.setFatherName( updateIndividualCustomerRequest.getFatherName() );
        individualCustomer.setNationalityId( updateIndividualCustomerRequest.getNationalityId() );
        individualCustomer.setBirthDate( updateIndividualCustomerRequest.getBirthDate() );

        return individualCustomer;
    }

    @Override
    public CreatedIndividualCustomerResponse createdIndividualCustomerResponseFromIndividualCustomer(IndividualCustomer individualCustomer) {
        if ( individualCustomer == null ) {
            return null;
        }

        CreatedIndividualCustomerResponse createdIndividualCustomerResponse = new CreatedIndividualCustomerResponse();

        createdIndividualCustomerResponse.setEmail( individualCustomerCustomerEmail( individualCustomer ) );
        createdIndividualCustomerResponse.setFirstName( individualCustomer.getFirstName() );
        createdIndividualCustomerResponse.setMiddleName( individualCustomer.getMiddleName() );
        createdIndividualCustomerResponse.setLastName( individualCustomer.getLastName() );
        createdIndividualCustomerResponse.setGender( individualCustomer.getGender() );
        createdIndividualCustomerResponse.setMotherName( individualCustomer.getMotherName() );
        createdIndividualCustomerResponse.setFatherName( individualCustomer.getFatherName() );
        createdIndividualCustomerResponse.setNationalityId( individualCustomer.getNationalityId() );
        createdIndividualCustomerResponse.setBirthDate( individualCustomer.getBirthDate() );

        return createdIndividualCustomerResponse;
    }

    @Override
    public UpdatedIndividualCustomerResponse updatedIndividualCustomerResponseFromIndividualCustomer(IndividualCustomer individualCustomer) {
        if ( individualCustomer == null ) {
            return null;
        }

        UpdatedIndividualCustomerResponse updatedIndividualCustomerResponse = new UpdatedIndividualCustomerResponse();

        updatedIndividualCustomerResponse.setEmail( individualCustomerCustomerEmail( individualCustomer ) );
        updatedIndividualCustomerResponse.setFirstName( individualCustomer.getFirstName() );
        updatedIndividualCustomerResponse.setMiddleName( individualCustomer.getMiddleName() );
        updatedIndividualCustomerResponse.setLastName( individualCustomer.getLastName() );
        updatedIndividualCustomerResponse.setGender( individualCustomer.getGender() );
        updatedIndividualCustomerResponse.setMotherName( individualCustomer.getMotherName() );
        updatedIndividualCustomerResponse.setFatherName( individualCustomer.getFatherName() );
        updatedIndividualCustomerResponse.setNationalityId( individualCustomer.getNationalityId() );
        updatedIndividualCustomerResponse.setBirthDate( individualCustomer.getBirthDate() );

        return updatedIndividualCustomerResponse;
    }

    @Override
    public DeletedIndividualCustomerResponse deleteIndividualCustomerResponseFromIndividualCustomer(IndividualCustomer individualCustomer) {
        if ( individualCustomer == null ) {
            return null;
        }

        DeletedIndividualCustomerResponse deletedIndividualCustomerResponse = new DeletedIndividualCustomerResponse();

        deletedIndividualCustomerResponse.setEmail( individualCustomerCustomerEmail( individualCustomer ) );
        deletedIndividualCustomerResponse.setFirstName( individualCustomer.getFirstName() );
        deletedIndividualCustomerResponse.setMiddleName( individualCustomer.getMiddleName() );
        deletedIndividualCustomerResponse.setLastName( individualCustomer.getLastName() );
        deletedIndividualCustomerResponse.setGender( individualCustomer.getGender() );
        deletedIndividualCustomerResponse.setMotherName( individualCustomer.getMotherName() );
        deletedIndividualCustomerResponse.setFatherName( individualCustomer.getFatherName() );
        deletedIndividualCustomerResponse.setNationalityId( individualCustomer.getNationalityId() );
        deletedIndividualCustomerResponse.setBirthDate( individualCustomer.getBirthDate() );

        return deletedIndividualCustomerResponse;
    }

    private String individualCustomerCustomerEmail(IndividualCustomer individualCustomer) {
        if ( individualCustomer == null ) {
            return null;
        }
        Customer customer = individualCustomer.getCustomer();
        if ( customer == null ) {
            return null;
        }
        String email = customer.getEmail();
        if ( email == null ) {
            return null;
        }
        return email;
    }
}

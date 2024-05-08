package com.etiyacrm.customerservice.services.mappers;

import com.etiyacrm.customerservice.entities.Address;
import com.etiyacrm.customerservice.services.dtos.requests.addressRequests.CreateAddressRequest;
import com.etiyacrm.customerservice.services.dtos.requests.addressRequests.UpdateAddressRequest;
import com.etiyacrm.customerservice.services.dtos.responses.addressResponses.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
@Mapper
public interface AddressMapper {
    AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);
    @Mapping(source = "address.customer.id", target = "customerId")
    @Mapping(source = "address.city.id", target = "cityId")
    GetAllAddressResponse getAllAddressResponseFromAddress(Address address);
    @Mapping(source = "address.customer.id", target = "customerId")
    @Mapping(source = "address.city.id", target = "cityId")
    GetAddressResponse getAddressResponseFromAddress(Address address);
    @Mapping(source = "createAddressRequest.customerId", target = "customer.id")
    @Mapping(source = "createAddressRequest.cityId", target = "city.id")
    Address addressFromCreateAddressRequest(CreateAddressRequest createAddressRequest);
    @Mapping(source = "address.customer.id", target = "customerId")
    @Mapping(source = "address.city.id", target = "cityId")
    CreatedAddressResponse createdAddressResponseFromAddress(Address address);
    @Mapping(source = "updateAddressRequest.customerId", target = "customer.id")
    @Mapping(source = "updateAddressRequest.cityId", target = "city.id")
    Address addressFromUpdateAddressRequest(UpdateAddressRequest updateAddressRequest);
    @Mapping(source = "address.customer.id", target = "customerId")
    @Mapping(source = "address.city.id", target = "cityId")
    UpdatedAddressResponse updatedAddressResponseFromAddress(Address address);
    @Mapping(source = "address.customer.id", target = "customerId")
    @Mapping(source = "address.city.id", target = "cityId")
    DeletedAddressResponse deletedAddressResponseFromAddress(Address address);
}

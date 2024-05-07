package com.etiyacrm.customerservice.services.mappers;

import com.etiyacrm.customerservice.entities.Address;
import com.etiyacrm.customerservice.services.dtos.requests.addressRequests.CreateAddressRequest;
import com.etiyacrm.customerservice.services.dtos.requests.addressRequests.UpdateAddressRequest;
import com.etiyacrm.customerservice.services.dtos.responses.addressResponses.*;
import org.mapstruct.factory.Mappers;

public interface AddressMapper {
    AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);

    GetAllAddressResponse getAllAddressResponseFromAddress(Address address);
    GetAddressResponse getAddressResponseFromAddress(Address address);
    Address addressFromCreateAddressRequest(CreateAddressRequest createAddressRequest);
    CreatedAddressResponse createdAddressResponseFromAddress(Address address);
    Address addressFromUpdateAddressRequest(UpdateAddressRequest updateAddressRequest);
    UpdatedAddressResponse updatedAddressResponseFromAddress(Address address);
    DeletedAddressResponse deletedAddressResponseFromAddress(Address address);
}

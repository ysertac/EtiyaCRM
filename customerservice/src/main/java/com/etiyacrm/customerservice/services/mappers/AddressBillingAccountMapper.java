package com.etiyacrm.customerservice.services.mappers;

import com.etiyacrm.customerservice.entities.AddressBillingAccount;
import com.etiyacrm.customerservice.services.dtos.requests.addressBillingAccountRequests.CreateAddressBillingAccountRequest;
import com.etiyacrm.customerservice.services.dtos.requests.addressBillingAccountRequests.UpdateAddressBillingAccountRequest;
import com.etiyacrm.customerservice.services.dtos.responses.addressBillingAccountResponses.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AddressBillingAccountMapper {
    AddressBillingAccountMapper INSTANCE = Mappers.getMapper(AddressBillingAccountMapper.class);

    @Mapping(source = "address.id", target = "addressId")
    @Mapping(source = "billingAccount.id", target = "billingAccountId")
    GetAddressBillingAccountResponse getAbaResponseFromAba(AddressBillingAccount addressBillingAccount);

    @Mapping(source = "address.id", target = "addressId")
    @Mapping(source = "billingAccount.id", target = "billingAccountId")
    GetAllAddressBillingAccountResponses getAllAbaResponseFromAba(AddressBillingAccount addressBillingAccount);

    @Mapping(source = "address.id", target = "addressId")
    @Mapping(source = "billingAccount.id", target = "billingAccountId")
    GetAddressBillingAccountResponseByAddressId getAbaResponseFromAbaByAddressId(AddressBillingAccount addressBillingAccount);

    @Mapping(source = "addressId", target = "address.id")
    @Mapping(source = "billingAccountId", target = "billingAccount.id")
    AddressBillingAccount abaFromCreateAbaRequest(CreateAddressBillingAccountRequest request);

    @Mapping(source = "address.id", target = "addressId")
    @Mapping(source = "billingAccount.id", target = "billingAccountId")
    CreatedAddressBillingAccountResponse createdAbaResponseFromAba(AddressBillingAccount addressBillingAccount);

    @Mapping(source = "addressId", target = "address.id")
    @Mapping(source = "billingAccountId", target = "billingAccount.id")
    AddressBillingAccount abaFromUpdateAbaRequest(UpdateAddressBillingAccountRequest request);

    @Mapping(source = "address.id", target = "addressId")
    @Mapping(source = "billingAccount.id", target = "billingAccountId")
    UpdatedAddressBillingAccountResponse updatedAbaResponseFromAba(AddressBillingAccount addressBillingAccount);

    @Mapping(source = "address.id", target = "addressId")
    @Mapping(source = "billingAccount.id", target = "billingAccountId")
    DeletedAddressBillingAccountResponse deletedAbaResponseFromAba(AddressBillingAccount addressBillingAccount);
}

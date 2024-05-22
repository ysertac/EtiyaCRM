package com.etiyacrm.customerservice.services.abstracts;

import com.etiyacrm.customerservice.services.dtos.requests.addressBillingAccountRequests.CreateAddressBillingAccountRequest;
import com.etiyacrm.customerservice.services.dtos.requests.addressBillingAccountRequests.UpdateAddressBillingAccountRequest;
import com.etiyacrm.customerservice.services.dtos.responses.addressBillingAccountResponses.*;

import java.util.List;

public interface AddressBillingAccountService {

    List<GetAllAddressBillingAccountResponses> getAll();
    GetAddressBillingAccountResponse getById(String id);
    List<GetAddressBillingAccountResponseByAddressId> getByAddressId(String addressId);
    CreatedAddressBillingAccountResponse create(CreateAddressBillingAccountRequest createAddressBillingAccountRequest);
    UpdatedAddressBillingAccountResponse update(String id, UpdateAddressBillingAccountRequest addressBillingAccountRequest);
    DeletedAddressBillingAccountResponse delete(String id);
}

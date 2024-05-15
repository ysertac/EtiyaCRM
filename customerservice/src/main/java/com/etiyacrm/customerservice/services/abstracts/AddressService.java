package com.etiyacrm.customerservice.services.abstracts;

import com.etiyacrm.customerservice.core.business.paging.PageInfo;
import com.etiyacrm.customerservice.core.responses.GetListResponse;
import com.etiyacrm.customerservice.services.dtos.requests.addressRequests.CreateAddressRequest;
import com.etiyacrm.customerservice.services.dtos.requests.addressRequests.UpdateAddressRequest;
import com.etiyacrm.customerservice.services.dtos.responses.addressResponses.*;

import java.util.List;
import java.util.Optional;

public interface AddressService {
    GetListResponse<GetAllAddressResponse> getAll(PageInfo pageInfo);
    GetAddressResponse getById(String id);
    CreatedAddressResponse add(CreateAddressRequest createAddressRequest);
    UpdatedAddressResponse update(UpdateAddressRequest updateAddressRequest, String id);
    DeletedAddressResponse delete(String id);
    List<GetAddressByCustomerIdResponse> getByCustomerId(String customerId);
}

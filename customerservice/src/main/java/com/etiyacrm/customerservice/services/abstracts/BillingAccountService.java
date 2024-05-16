package com.etiyacrm.customerservice.services.abstracts;

import com.etiyacrm.customerservice.services.dtos.requests.billingAccountRequests.CreateBillingAccountRequest;
import com.etiyacrm.customerservice.services.dtos.requests.billingAccountRequests.UpdateBillingAccountRequest;
import com.etiyacrm.customerservice.services.dtos.responses.billingAccountResponses.*;

import java.util.List;

public interface BillingAccountService {
    List<GetAllBillingAccountResponse> getAll();
    List<GetBillingAccountResponse> getByCustomerId(String id);
    CreatedBillingAccountResponse add(CreateBillingAccountRequest createBillingAccountRequest);
    UpdatedBillingAccountResponse update(UpdateBillingAccountRequest updateBillingAccountRequest, String id);
    DeletedBillingAccountResponse delete(String id);
}

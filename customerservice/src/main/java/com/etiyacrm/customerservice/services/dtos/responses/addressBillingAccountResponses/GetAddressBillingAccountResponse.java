package com.etiyacrm.customerservice.services.dtos.responses.addressBillingAccountResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAddressBillingAccountResponse {
    private String id;
    private String billingAccountId;
    private String addressId;
}

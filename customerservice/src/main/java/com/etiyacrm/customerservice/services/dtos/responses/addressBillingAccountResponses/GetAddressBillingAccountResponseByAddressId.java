package com.etiyacrm.customerservice.services.dtos.responses.addressBillingAccountResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAddressBillingAccountResponseByAddressId {
    private String id;
    private String billingAccountId;
    private String addressId;
}

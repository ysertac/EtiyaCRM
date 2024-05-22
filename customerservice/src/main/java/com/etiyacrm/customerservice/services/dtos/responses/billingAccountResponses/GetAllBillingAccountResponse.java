package com.etiyacrm.customerservice.services.dtos.responses.billingAccountResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllBillingAccountResponse {
    private String id;
    private String name;
    private boolean status;
    private String accountNumber;
    private String type;
    private String description;
    private String customerId;
}

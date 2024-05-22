package com.etiyacrm.customerservice.services.dtos.requests.billingAccountRequests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateBillingAccountRequest {
    @NotBlank(message = "Account name can not be empty")
    @NotNull
    @Size(max = 20, message = "Account name may has maximum 20 characters")
    private String name;

    //private boolean status;

    private String accountNumber;

    //private String type;

    @NotBlank(message = "Account description can not be empty")
    @NotNull
    @Size(max = 200, message = "Account description may has maximum 200 characters")
    private String description;

    private String customerId;
}

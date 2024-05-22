package com.etiyacrm.customerservice.services.dtos.requests.addressBillingAccountRequests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateAddressBillingAccountRequest {
    @NotNull
    @NotBlank
    private String billingAccountId;

    @NotNull
    @NotBlank
    private String addressId;
}

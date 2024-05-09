package com.etiyacrm.customerservice.services.dtos.requests.addressRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateAddressRequest {
    private String description;
    private String neighbourhood;
    private String houseNumber;
    private String district;
    private String street;
    private String cityId;
    private String customerId;
}

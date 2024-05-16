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
    private String street;
    private String countryId;
    private String cityId;
    private String districtId;
    private String customerId;
}
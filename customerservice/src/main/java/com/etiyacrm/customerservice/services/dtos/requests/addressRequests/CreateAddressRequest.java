package com.etiyacrm.customerservice.services.dtos.requests.addressRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateAddressRequest {

    private String street;
    private String district;
    private String neighborhood;
    private String houseNumber;
    private String description;
    private int cityId;

}

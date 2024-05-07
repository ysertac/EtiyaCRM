package com.etiyacrm.customerservice.services.dtos.responses.addressResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatedAddressResponse {
    private long id;
    private String street;
    private String district;
    private String neighborhood;
    private String houseNumber;
    private String description;
    private int cityId;
}

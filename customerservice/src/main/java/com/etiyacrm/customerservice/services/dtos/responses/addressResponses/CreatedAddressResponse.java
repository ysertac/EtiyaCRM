package com.etiyacrm.customerservice.services.dtos.responses.addressResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatedAddressResponse {
    private String id;
    private String description;
    private String neighbourhood;
    private String houseNumber;
    private String street;
    private String countryId;
    private String cityId;
    private String districtId;
    private String customerId;
}

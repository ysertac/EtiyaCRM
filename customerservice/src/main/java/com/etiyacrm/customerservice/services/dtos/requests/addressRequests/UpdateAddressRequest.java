package com.etiyacrm.customerservice.services.dtos.requests.addressRequests;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateAddressRequest {
    @Size(max = 200, message = "Address description may has maximum 200 characters")
    private String description;

    @Size(max = 30, message = "Neighbourhood may has maximum 20 characters")
    private String neighbourhood;

    @Size(max = 30, message = "Neighbourhood may has maximum 20 characters")
    private String houseNumber;

    @Size(max = 30, message = "Neighbourhood may has maximum 20 characters")
    private String street;

    private String countryId;

    private String cityId;

    private String districtId;

    private String customerId;
}

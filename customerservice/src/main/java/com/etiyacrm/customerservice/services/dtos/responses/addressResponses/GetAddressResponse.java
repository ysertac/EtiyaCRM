package com.etiyacrm.customerservice.services.dtos.responses.addressResponses;

import com.etiyacrm.customerservice.entities.City;
import com.etiyacrm.customerservice.entities.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAddressResponse {
    private String id;
    private String description;
    private String neighbourhood;
    private String houseNumber;
    private String districtId;
    private String street;
    private String countryId;
    private String cityId;
    private String customerId;
}

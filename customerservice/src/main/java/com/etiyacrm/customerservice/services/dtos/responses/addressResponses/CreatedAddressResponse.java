package com.etiyacrm.customerservice.services.dtos.responses.addressResponses;

import com.etiyacrm.customerservice.entities.City;
import com.etiyacrm.customerservice.entities.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatedAddressResponse {
    private long id;
    private String description;
    private String neighbourhood;
    private String houseNumber;
    private String district;
    private String street;
    private long cityId;
    private long customerId;
}

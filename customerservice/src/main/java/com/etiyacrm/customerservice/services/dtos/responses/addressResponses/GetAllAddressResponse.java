package com.etiyacrm.customerservice.services.dtos.responses.addressResponses;

import com.etiyacrm.customerservice.entities.City;
import com.etiyacrm.customerservice.entities.Customer;

public class GetAllAddressResponse {
    private long id;
    private String description;
    private String neighbourhood;
    private String houseNumber;
    private String district;
    private String street;
    private City city;
    private Customer customer;
}

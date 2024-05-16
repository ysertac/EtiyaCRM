package com.etiyacrm.customerservice.services.dtos.responses.CityResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeletedCityResponse {
    private String id;
    private String name;
    private String countryId;
}

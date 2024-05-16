package com.etiyacrm.customerservice.services.dtos.responses.CountryResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdatedCountryResponse {
    private String id;
    private String name;
}

package com.etiyacrm.customerservice.services.dtos.responses.districtResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdatedDistrictResponse {
    private String id;
    private String name;
    private String cityId;
}

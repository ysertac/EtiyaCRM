package com.etiyacrm.customerservice.services.dtos.requests.cityRequests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCityRequest {
    @NotNull
    @NotEmpty
    @NotBlank
    @Size(min = 3, max = 20)
    private String name;

    @NotNull
    @NotEmpty
    @NotBlank
    private String countryId;
}

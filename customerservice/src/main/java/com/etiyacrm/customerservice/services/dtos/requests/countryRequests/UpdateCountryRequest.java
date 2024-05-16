package com.etiyacrm.customerservice.services.dtos.requests.countryRequests;

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
public class UpdateCountryRequest {
    @NotNull
    @NotEmpty
    @NotBlank
    @Size(min = 3, max = 20)
    private String name;
}

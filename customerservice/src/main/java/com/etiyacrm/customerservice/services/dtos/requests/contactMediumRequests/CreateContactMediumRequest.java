package com.etiyacrm.customerservice.services.dtos.requests.contactMediumRequests;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateContactMediumRequest {
    @NotNull
    @Pattern(regexp = "\\b[A-Za-z0-9._%+-]+@(?:[A-Za-z0-9-]+\\.)+[A-Z|a-z]{2,}\\b", message = "E-mail must be a valid e-mail address")
    private String email;

    @Nullable
    @Pattern(regexp = "^$|\\d{10}", message = "Home Phone must have 10 characters and contain only numbers.")
    private String homePhone;

    @NotNull
    @Pattern(regexp = "^5\\d{9}$", message = "Phone number must be written in (5xx)-xxx-xx-xx format")
    private String mobilePhone;

    @Nullable
    @Pattern(regexp = "^$|\\d{10}", message = "Fax must have 10 characters and contain only numbers.")
    private String fax;
    private String customerId;
}

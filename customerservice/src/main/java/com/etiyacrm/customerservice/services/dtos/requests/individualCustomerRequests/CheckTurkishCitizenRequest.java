package com.etiyacrm.customerservice.services.dtos.requests.individualCustomerRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CheckTurkishCitizenRequest {
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String nationalityId;

}

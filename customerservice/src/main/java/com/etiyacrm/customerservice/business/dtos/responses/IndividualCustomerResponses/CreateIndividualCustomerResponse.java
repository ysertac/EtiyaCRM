package com.etiyacrm.customerservice.business.dtos.responses.IndividualCustomerResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateIndividualCustomerResponse {
    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private String gender;
    private String motherName;
    private String fatherName;
    private String nationalityId;
    private LocalDateTime birthDate;
}

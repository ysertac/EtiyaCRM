package com.etiyacrm.customerservice.services.dtos.responses.IndividualCustomerResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetIndividualCustomerResponse {
    private String id;
    private String customerId;
    private String firstName;
    private String middleName;
    private String lastName;
    private String gender;
    private String motherName;
    private String fatherName;
    private String nationalityId;
    private LocalDate birthDate;
}

package com.example.searchservice.services.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class PostSearchCustomerResponse {
    String customerId;
    String nationalityId;
    String firstName;
    String middleName;
    String lastName;
    String role;
}

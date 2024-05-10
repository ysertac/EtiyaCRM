package com.example.searchservice.services.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostSearchCustomerRequest {
    String customerId;
    String nationalityId;
    String accountNumber;
    String mobilePhone;
    String firstName;
    String lastName;
    String orderNumber;
}
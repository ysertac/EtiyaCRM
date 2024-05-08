package com.etiyacrm.customerservice.services.dtos.responses.contactMediumResponses;

import com.etiyacrm.customerservice.entities.Customer;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatedContactMediumResponse {
    private long id;
    private String email;
    private String homePhone;
    private String mobilePhone;
    private String fax;
    private long customerId;
}

package com.etiyacrm.customerservice.services.dtos.requests.contactMediumRequests;

import com.etiyacrm.customerservice.entities.Customer;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateContactMediumRequest {
    private String email;
    private String homePhone;
    private String mobilePhone;
    private String fax;
    private String customerId;
}

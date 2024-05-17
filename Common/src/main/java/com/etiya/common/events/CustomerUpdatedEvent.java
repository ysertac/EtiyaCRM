package com.etiya.common.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerUpdatedEvent {
    private String customerId;
    private String firstName;
    private String middleName;
    private String lastname;
    private String nationalityId;
}

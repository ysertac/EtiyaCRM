package com.example.searchservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "search-customer")
public class Customer {
    @Id
    private String id;

    @Field(name = "customerId")
    private String customerId;

    @Field(name= "customerNumber")
    private long customerNumber;

    @Field(name = "firstName")
    private String firstName;

    @Field(name = "middleName")
    private String middleName;

    @Field(name = "lastName")
    private String lastName;

    @Field(name = "mobilePhone")
    private String mobilePhone;

    @Field(name = "nationalityId")
    private String nationalityId;
}

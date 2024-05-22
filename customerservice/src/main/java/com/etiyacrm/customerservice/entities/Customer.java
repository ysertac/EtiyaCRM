package com.etiyacrm.customerservice.entities;

import com.etiyacrm.customerservice.core.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;

import java.util.List;

@Entity
@Table(name = "customers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer extends BaseEntity {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "customerNumber", unique = true)
    private long customerNumber;

    @OneToOne(mappedBy = "customer")
    private IndividualCustomer individualCustomer;

    @OneToMany(mappedBy = "customer")
    private List<Address> addresses;

    @OneToOne(mappedBy = "customer")
    private ContactMedium contactMedium;

    @OneToMany(mappedBy = "customer")
    private List<BillingAccount> billingAccounts;
}

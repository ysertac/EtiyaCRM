package com.etiyacrm.customerservice.entities;

import com.etiyacrm.customerservice.core.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "billing_accounts")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BillingAccount extends BaseEntity {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name="name")
    private String name;

    @Column(name="status")
    private boolean status;

    @Column(name="account_number")
    private String accountNumber;

    @Column(name="type")
    private String type;

    @Column(name="description")
    private String description;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToMany(mappedBy = "billingAccount", cascade = CascadeType.MERGE)
    private List<AddressBillingAccount> addressBillingAccounts;

}

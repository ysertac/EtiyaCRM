package com.etiyacrm.customerservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "addresses")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Address {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "description")
    private String descripion;

    @Column(name = "neighbourhood")
    private String neighbourhood;

    @Column(name = "houseNumber")
    private String houseNumber;

    @Column(name = "district")
    private String district;

    @Column(name = "street")
    private String street;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;
}

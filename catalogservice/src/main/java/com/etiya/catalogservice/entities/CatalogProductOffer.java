package com.etiya.catalogservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity()
@Table(name = "catalog-product-offers")
public class CatalogProductOffer {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne()
    @JoinColumn(name = "catalog_id")
    private Catalog catalog;

    @ManyToOne()
    @JoinColumn(name = "productOffer_id")
    private ProductOffer productOffer;
}

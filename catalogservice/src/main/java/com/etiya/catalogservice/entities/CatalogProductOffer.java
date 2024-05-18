package com.etiya.catalogservice.entities;

import com.etiya.catalogservice.core.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity()
@Table(name = "catalog-product-offers")
@Where(clause = "deleted_date IS NULL")
public class CatalogProductOffer extends BaseEntity {

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

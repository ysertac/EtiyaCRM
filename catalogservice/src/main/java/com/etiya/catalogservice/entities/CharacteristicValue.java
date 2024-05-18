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
@Table(name = "characteristic_values")
@Where(clause = "deleted_date IS NULL")
public class CharacteristicValue extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private String id;

    @Column(name = "value")
    private String value;

    @Column(name = "is_active")
    private boolean isActive;

    @ManyToOne()
    @JoinColumn(name = "characteristic_id")
    private Characteristic characteristic;
}

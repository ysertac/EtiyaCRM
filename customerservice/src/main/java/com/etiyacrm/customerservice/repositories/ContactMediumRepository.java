package com.etiyacrm.customerservice.repositories;

import com.etiyacrm.customerservice.entities.ContactMedium;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactMediumRepository extends JpaRepository<ContactMedium, String> {
    ContactMedium findByCustomerId(String customerId);
}

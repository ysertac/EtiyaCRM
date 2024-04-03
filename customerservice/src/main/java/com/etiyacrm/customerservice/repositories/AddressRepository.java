package com.etiyacrm.customerservice.repositories;

import com.etiyacrm.customerservice.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}

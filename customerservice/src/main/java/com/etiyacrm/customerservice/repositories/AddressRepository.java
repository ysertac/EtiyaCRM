package com.etiyacrm.customerservice.repositories;

import com.etiyacrm.customerservice.entities.Address;
import com.etiyacrm.customerservice.services.dtos.responses.addressResponses.GetAddressByCustomerIdResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, String> {
    @Query(value = "SELECT * FROM addresses WHERE deleted_date IS null", nativeQuery = true)
    Page<Address> findAllIfDeletedDateIsNull(Pageable pageable);

    @Query(value = "SELECT * FROM addresses WHERE deleted_date IS null AND customer_id = ?1 ", nativeQuery = true)
    Page<Address> findAllIfDeletedDateIsNullWithCustomerId(Pageable pageable,String customerId);

    List<Address> findByCustomerId(String customerId);
}

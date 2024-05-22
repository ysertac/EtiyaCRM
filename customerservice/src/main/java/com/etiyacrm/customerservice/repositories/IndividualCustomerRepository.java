package com.etiyacrm.customerservice.repositories;

import com.etiyacrm.customerservice.entities.IndividualCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface IndividualCustomerRepository extends JpaRepository<IndividualCustomer, String> {
    @Query(value = "SELECT ic.* FROM individual_customers ic INNER JOIN customers c ON ic.customer_id=c.id WHERE c.deleted_date IS null And ic.nationality_id=:nationalityId", nativeQuery = true)
    Optional<IndividualCustomer> findByNationalityIdAndDeletedDateIsNull(@Param("nationalityId") String nationalityId);

}

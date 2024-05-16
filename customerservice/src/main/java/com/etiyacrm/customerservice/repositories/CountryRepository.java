package com.etiyacrm.customerservice.repositories;

import com.etiyacrm.customerservice.entities.Country;
import com.etiyacrm.customerservice.entities.District;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CountryRepository extends JpaRepository<Country,String> {
    Optional<Country> findByNameIgnoreCase(String name);
    @Query(value = "SELECT * FROM countries WHERE deleted_date IS null", nativeQuery = true)
    List<Country> findAllIfDeletedDateIsNull();
}

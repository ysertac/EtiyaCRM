package com.etiyacrm.customerservice.repositories;

import com.etiyacrm.customerservice.entities.Address;
import com.etiyacrm.customerservice.entities.City;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CityRepository extends JpaRepository<City, String> {
    Optional<City> findByNameIgnoreCase(String name);
    @Query(value = "SELECT * FROM cities WHERE deleted_date IS null", nativeQuery = true)
    Page<City> findAllIfDeletedDateIsNull(Pageable pageable);
    List<City> findByCountryId(String countryId);
}

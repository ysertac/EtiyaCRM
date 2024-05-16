package com.etiyacrm.customerservice.repositories;

import com.etiyacrm.customerservice.entities.City;
import com.etiyacrm.customerservice.entities.District;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface DistrictRepository extends JpaRepository<District, String> {
    Optional<District> findByNameIgnoreCase(String name);
    @Query(value = "SELECT * FROM districts WHERE deleted_date IS null", nativeQuery = true)
    List<District> findAllIfDeletedDateIsNull();
    List<District> findByCityId(String cityId);
}

package com.etiya.catalogservice.repositories;

import com.etiya.catalogservice.entities.Campaign;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CampaignRepository extends JpaRepository<Campaign, String> {
}

package com.etiya.catalogservice.repositories;

import com.etiya.catalogservice.entities.Campaign;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;

public interface CampaignRepository extends JpaRepository<Campaign, String> {

}

package com.etiyacrm.customerservice.repositories;

import com.etiyacrm.customerservice.entities.AddressBillingAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressBillingAccountRepository extends JpaRepository<AddressBillingAccount, String> {
    List<AddressBillingAccount> findByAddressId(String addressId);
}

package com.etiyacrm.customerservice.services.concretes;

import com.etiyacrm.customerservice.entities.BillingAccount;
import com.etiyacrm.customerservice.repositories.BillingAccountRepository;
import com.etiyacrm.customerservice.services.abstracts.BillingAccountService;
import com.etiyacrm.customerservice.services.dtos.requests.billingAccountRequests.CreateBillingAccountRequest;
import com.etiyacrm.customerservice.services.dtos.requests.billingAccountRequests.UpdateBillingAccountRequest;
import com.etiyacrm.customerservice.services.dtos.responses.billingAccountResponses.*;
import com.etiyacrm.customerservice.services.mappers.BillingAccountMapper;
import com.etiyacrm.customerservice.services.rules.BillingAccountBusinessRules;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BillingAccountServiceImpl implements BillingAccountService {
    private BillingAccountRepository billingAccountRepository;
    private BillingAccountBusinessRules billingAccountBusinessRules;

    @Override
    public List<GetAllBillingAccountResponse> getAll() {
        List<BillingAccount> response = billingAccountRepository.findAll();
        List<GetAllBillingAccountResponse> getAllBillingAccountResponses = response.stream()
                .filter(billingAccount -> billingAccount.getDeletedDate() == null)
                .map(billingAccount -> BillingAccountMapper.INSTANCE.getAllBillingAccountResponse(billingAccount))
                .collect(Collectors.toList());
        return getAllBillingAccountResponses;
    }

    @Override
    public List<GetBillingAccountResponse> getByCustomerId(String id) {
        billingAccountBusinessRules.billingAccountIsDeleted(id);

        List<BillingAccount> billingAccounts = billingAccountRepository.findByCustomerId(id);
        List<GetBillingAccountResponse> getBillingAccountList =
                billingAccounts.stream()
                        .map(BillingAccountMapper.INSTANCE::getBillingAccountResponseFromBillingAccount)
                        .collect(Collectors.toList());
        return getBillingAccountList;
    }

    @Override
    public CreatedBillingAccountResponse add(CreateBillingAccountRequest createBillingAccountRequest) {
        BillingAccount billingAccount =
                BillingAccountMapper.INSTANCE.billingAccountFromCreateBillingAccountRequest(createBillingAccountRequest);

        BillingAccount createdBillingAccount =
                billingAccountRepository.save(billingAccount);

        CreatedBillingAccountResponse createdBillingAccountResponse =
                BillingAccountMapper.INSTANCE.createdBillingAccountResponseFromBillingAccount(createdBillingAccount);

        return createdBillingAccountResponse;
    }

    @Override
    public UpdatedBillingAccountResponse update(UpdateBillingAccountRequest updateBillingAccountRequest, String id) {
        billingAccountBusinessRules.billingAccountNotFound(id);
        billingAccountBusinessRules.billingAccountIsDeleted(id);

        BillingAccount savedBillingAccount = billingAccountRepository.findById(id).get();

        BillingAccount billingAccount = BillingAccountMapper.INSTANCE.billingAccountFromUpdateBillingAccountRequest(updateBillingAccountRequest);

        billingAccount.setId(id);
        billingAccount.setCustomer(savedBillingAccount.getCustomer());
        billingAccount.setUpdatedDate(LocalDateTime.now());
        BillingAccount updatedBillingAccount = billingAccountRepository.save(billingAccount);

        UpdatedBillingAccountResponse updatedBillingAccountResponse =
                BillingAccountMapper.INSTANCE.updatedBillingAccountResponseFromBillingAccount(updatedBillingAccount);

        return updatedBillingAccountResponse;
    }

    @Override
    public DeletedBillingAccountResponse delete(String id) {
        billingAccountBusinessRules.billingAccountNotFound(id);
        billingAccountBusinessRules.billingAccountIsDeleted(id);

        BillingAccount billingAccount = billingAccountRepository.findById(id).get();
        billingAccount.setId(id);
        billingAccount.setDeletedDate(LocalDateTime.now());
        BillingAccount deletedBillingAccount = billingAccountRepository.save(billingAccount);

        DeletedBillingAccountResponse deletedBillingAccountResponse =
                BillingAccountMapper.INSTANCE.deletedBillingAccountResponseFromBillingAccount(deletedBillingAccount);
        return deletedBillingAccountResponse;
    }
}

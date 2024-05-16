package com.etiyacrm.customerservice.services.rules;

import com.etiyacrm.customerservice.core.business.abstracts.MessageService;
import com.etiyacrm.customerservice.core.crossCuttingConcerns.exceptions.types.BusinessException;
import com.etiyacrm.customerservice.entities.BillingAccount;
import com.etiyacrm.customerservice.repositories.BillingAccountRepository;
import com.etiyacrm.customerservice.services.messages.Messages;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class BillingAccountBusinessRules {
    private MessageService messageService;
    private BillingAccountRepository billingAccountRepository;

    public void billingAccountNotFound(String id) {
        Optional<BillingAccount> billingAccount = billingAccountRepository.findById(id);

        if (billingAccount.isEmpty()) {
            throw new BusinessException(messageService.getMessage(Messages.BusinessErrors.BILLING_ACCOUNT_NOT_FOUND));
        }
    }

    public void billingAccountIsDeleted(String id) {
        Optional<BillingAccount> billingAccount = billingAccountRepository.findById(id);

        if (billingAccount.isPresent() && billingAccount.get().getDeletedDate() != null) {
            throw new BusinessException(messageService.getMessage(Messages.BusinessErrors.BILLING_ACCOUNT_IS_DELETED));
        }
    }
}

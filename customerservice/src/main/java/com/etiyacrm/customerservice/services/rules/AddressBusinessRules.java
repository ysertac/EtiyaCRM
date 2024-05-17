package com.etiyacrm.customerservice.services.rules;

import com.etiyacrm.customerservice.core.business.abstracts.MessageService;
import com.etiyacrm.customerservice.core.crossCuttingConcerns.exceptions.types.BusinessException;
import com.etiyacrm.customerservice.entities.Address;
import com.etiyacrm.customerservice.repositories.AddressRepository;
import com.etiyacrm.customerservice.services.messages.Messages;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class AddressBusinessRules {
    private AddressRepository addressRepository;
    private MessageService messageService;

    public void addressNotFound(String id) {
        Optional<Address> address = addressRepository.findById(id);

        if (address.isEmpty()) {
            throw new BusinessException(messageService.getMessage(Messages.BusinessErrors.ADDRESS_NOT_FOUND));
        }
    }

    public void addressIsDeleted(String id) {
        Optional<Address> address = addressRepository.findById(id);

        if (address.isPresent() && address.get().getDeletedDate() != null) {
            throw new BusinessException(messageService.getMessage(Messages.BusinessErrors.ADDRESS_IS_DELETED));
        }
    }
}

package com.etiyacrm.customerservice.services.rules;

import com.etiyacrm.customerservice.core.business.abstracts.MessageService;
import com.etiyacrm.customerservice.core.crossCuttingConcerns.exceptions.types.BusinessException;
import com.etiyacrm.customerservice.entities.Country;
import com.etiyacrm.customerservice.entities.District;
import com.etiyacrm.customerservice.repositories.CountryRepository;
import com.etiyacrm.customerservice.services.messages.Messages;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CountryBusinessRules {
    private MessageService messageService;
    private CountryRepository countryRepository;

    public void countryNameCanNotBeDuplicated(String name) {
        Optional<Country> country = countryRepository.findByNameIgnoreCase(name);

        if (country.isPresent()) {
            throw new BusinessException(messageService.getMessage(Messages.BusinessErrors.COUNTRY_NAME_EXISTS));
        }
    }

    public void countryNotFound(String id) {
        Optional<Country> country = countryRepository.findById(id);

        if (country.isEmpty()) {
            throw new BusinessException(messageService.getMessage(Messages.BusinessErrors.COUNTRY_NOT_FOUND));
        }
    }

    public void countryIsDeleted(String id) {
        Optional<Country> country = countryRepository.findById(id);

        if (country.isPresent() && country.get().getDeletedDate() != null) {
            throw new BusinessException(messageService.getMessage(Messages.BusinessErrors.COUNTRY_IS_DELETED));
        }
    }
}

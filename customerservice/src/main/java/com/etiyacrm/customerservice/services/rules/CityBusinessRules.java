package com.etiyacrm.customerservice.services.rules;

import com.etiyacrm.customerservice.core.business.abstracts.MessageService;
import com.etiyacrm.customerservice.core.crossCuttingConcerns.exceptions.types.BusinessException;
import com.etiyacrm.customerservice.entities.City;
import com.etiyacrm.customerservice.repositories.CityRepository;
import com.etiyacrm.customerservice.services.messages.Messages;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CityBusinessRules {
    private MessageService messageService;
    private CityRepository cityRepository;

    public void cityNameCanNotBeDuplicated(String name) {
        Optional<City> city = cityRepository.findByNameIgnoreCase(name);

        if (city.isPresent()) {
            throw new BusinessException(messageService.getMessage(Messages.BusinessErrors.CITY_NAME_EXISTS));
        }
    }

    public void cityNotFound(String id) {
        Optional<City> city = cityRepository.findById(id);

        if (city.isEmpty()) {
            throw new BusinessException(messageService.getMessage(Messages.BusinessErrors.CITY_NOT_FOUND));
        }
    }

    public void cityIsDeleted(String id) {
        Optional<City> city = cityRepository.findById(id);

        if (city.isPresent() && city.get().getDeletedDate() != null) {
            throw new BusinessException(messageService.getMessage(Messages.BusinessErrors.CITY_IS_DELETED));
        }
    }
}

package com.etiyacrm.customerservice.services.rules;

import com.etiyacrm.customerservice.core.business.abstracts.MessageService;
import com.etiyacrm.customerservice.core.crossCuttingConcerns.exceptions.types.BusinessException;
import com.etiyacrm.customerservice.entities.City;
import com.etiyacrm.customerservice.entities.District;
import com.etiyacrm.customerservice.repositories.DistrictRepository;
import com.etiyacrm.customerservice.services.messages.Messages;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class DistrictBusinessRules {
    private MessageService messageService;
    private DistrictRepository districtRepository;

    public void districtNameCanNotBeDuplicated(String name) {
        Optional<District> district = districtRepository.findByNameIgnoreCase(name);

        if (district.isPresent()) {
            throw new BusinessException(messageService.getMessage(Messages.BusinessErrors.DISTRICT_NAME_EXISTS));
        }
    }

    public void districtNotFound(String id) {
        Optional<District> district = districtRepository.findById(id);

        if (district.isEmpty()) {
            throw new BusinessException(messageService.getMessage(Messages.BusinessErrors.DISTRICT_NOT_FOUND));
        }
    }

    public void districtIsDeleted(String id) {
        Optional<District> district = districtRepository.findById(id);

        if (district.isPresent() && district.get().getDeletedDate() != null) {
            throw new BusinessException(messageService.getMessage(Messages.BusinessErrors.DISTRICT_IS_DELETED));
        }
    }
}

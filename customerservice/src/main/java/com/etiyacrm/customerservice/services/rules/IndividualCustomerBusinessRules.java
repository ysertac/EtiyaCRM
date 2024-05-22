package com.etiyacrm.customerservice.services.rules;

import com.etiyacrm.customerservice.adapters.CustomerCheckService;
import com.etiyacrm.customerservice.core.business.abstracts.MessageService;
import com.etiyacrm.customerservice.core.crossCuttingConcerns.exceptions.types.BusinessException;
import com.etiyacrm.customerservice.entities.IndividualCustomer;
import com.etiyacrm.customerservice.repositories.IndividualCustomerRepository;
import com.etiyacrm.customerservice.services.messages.Messages;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class IndividualCustomerBusinessRules {
    private MessageService messageService;
    private IndividualCustomerRepository individualCustomerRepository;
    private CustomerCheckService customerCheckService;

    public void individualCustomerNationalityIdCannotBeDuplicated(String nationalityId) {
        Optional<IndividualCustomer> individualCustomer = individualCustomerRepository.findByNationalityIdAndDeletedDateIsNull(nationalityId);
        if(individualCustomer.isPresent() && individualCustomer.get().getCustomer().getDeletedDate() == null){
            throw new BusinessException(messageService.getMessage(Messages.BusinessErrors.NATIONALITY_ID_EXISTS));
        }
    }

    public void individualCustomerNationalityIdIsExist(String id, String nationalityId) {
        Optional<IndividualCustomer> individualCustomer = individualCustomerRepository.findByNationalityIdAndDeletedDateIsNull(nationalityId);
        if(individualCustomer.isPresent()){
            if(!individualCustomer.get().getId().equals(id)){
                throw new BusinessException(messageService.getMessage(Messages.BusinessErrors.NATIONALITY_ID_EXISTS));
            }
        }
    }

    public void individualCustomerIdMustExist(String id) {
        Optional<IndividualCustomer> individualCustomer = individualCustomerRepository.findById(id);
        if(!individualCustomer.isPresent() || individualCustomer.get().getCustomer().getDeletedDate() != null) {
            throw new BusinessException(messageService.getMessage(Messages.BusinessErrors.INDIVIDUAL_CUSTOMER_NOT_FOUND));
        }
    }

    public void checkIdNationalIdentityExists(String nationalityId,
                                              String firstName,
                                              String lastName,
                                              int birthDate) throws Exception {
        if(!customerCheckService.checkIfRealPerson(nationalityId, firstName, lastName, birthDate)){
            throw new BusinessException(messageService.getMessage(Messages.BusinessErrors.IDENTITY_NUMBER_NOT_EXISTS));
        }
    }

}

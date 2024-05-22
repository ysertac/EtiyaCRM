package com.etiyacrm.customerservice.services.concretes;

import com.etiyacrm.customerservice.entities.AddressBillingAccount;
import com.etiyacrm.customerservice.repositories.AddressBillingAccountRepository;
import com.etiyacrm.customerservice.services.abstracts.AddressBillingAccountService;
import com.etiyacrm.customerservice.services.dtos.requests.addressBillingAccountRequests.CreateAddressBillingAccountRequest;
import com.etiyacrm.customerservice.services.dtos.requests.addressBillingAccountRequests.UpdateAddressBillingAccountRequest;
import com.etiyacrm.customerservice.services.dtos.responses.addressBillingAccountResponses.*;
import com.etiyacrm.customerservice.services.mappers.AddressBillingAccountMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AddressBillingAccountServiceImpl implements AddressBillingAccountService {
    private AddressBillingAccountRepository addressBillingAccountRepository;
    @Override
    public CreatedAddressBillingAccountResponse create(CreateAddressBillingAccountRequest createAddressBillingAccountRequest) {
        AddressBillingAccount addressBillingAccount =
                AddressBillingAccountMapper.INSTANCE.abaFromCreateAbaRequest(createAddressBillingAccountRequest);
        addressBillingAccount.setCreatedDate(LocalDateTime.now());
        addressBillingAccount.setId(UUID.randomUUID().toString());
        AddressBillingAccount createdAddressBillingAccount =
                addressBillingAccountRepository.save(addressBillingAccount);
        CreatedAddressBillingAccountResponse response =
                AddressBillingAccountMapper.INSTANCE.createdAbaResponseFromAba(createdAddressBillingAccount);
        return response;
    }

    @Override
    public List<GetAllAddressBillingAccountResponses> getAll() {
        List<AddressBillingAccount> allAddressBillingAccounts = addressBillingAccountRepository.findAll();
        List<GetAllAddressBillingAccountResponses> getAllAddressBillingAccountResponses =
                allAddressBillingAccounts.stream().map(AddressBillingAccountMapper.INSTANCE::getAllAbaResponseFromAba).collect(Collectors.toList());
        return getAllAddressBillingAccountResponses;
    }

    @Override
    public List<GetAddressBillingAccountResponseByAddressId> getByAddressId(String addressId) {
        List<AddressBillingAccount> addressBillingAccounts = addressBillingAccountRepository.findByAddressId(addressId);
        List<GetAddressBillingAccountResponseByAddressId> response =
                addressBillingAccounts.stream().map(AddressBillingAccountMapper.INSTANCE::getAbaResponseFromAbaByAddressId).collect(Collectors.toList());
        return response;
    }

    @Override
    public GetAddressBillingAccountResponse getById(String id) {
        AddressBillingAccount foundAba = addressBillingAccountRepository.findById(id).get();
        GetAddressBillingAccountResponse getAddressBillingAccountResponse =
                AddressBillingAccountMapper.INSTANCE.getAbaResponseFromAba(foundAba);
        return getAddressBillingAccountResponse;
    }

    @Override
    public UpdatedAddressBillingAccountResponse update(String id, UpdateAddressBillingAccountRequest updateAddressBillingAccountRequest) {
        AddressBillingAccount foundAba = addressBillingAccountRepository.findById(id).get();
        AddressBillingAccount addressBillingAccount =
                AddressBillingAccountMapper.INSTANCE.abaFromUpdateAbaRequest(updateAddressBillingAccountRequest);
        addressBillingAccount.setId(foundAba.getId());
        addressBillingAccount.setAddress(foundAba.getAddress());
        addressBillingAccount.setBillingAccount(foundAba.getBillingAccount());
        addressBillingAccount.setUpdatedDate(LocalDateTime.now());

        AddressBillingAccount updatedAba = addressBillingAccountRepository.save(addressBillingAccount);
        UpdatedAddressBillingAccountResponse response =
                AddressBillingAccountMapper.INSTANCE.updatedAbaResponseFromAba(updatedAba);
        return response;
    }

    @Override
    public DeletedAddressBillingAccountResponse delete(String id) {
        AddressBillingAccount foundAba = addressBillingAccountRepository.findById(id).get();
        foundAba.setId(id);
        foundAba.setDeletedDate(LocalDateTime.now());
        addressBillingAccountRepository.save(foundAba);
        DeletedAddressBillingAccountResponse response = AddressBillingAccountMapper.INSTANCE.deletedAbaResponseFromAba(foundAba);
        return response;
    }
}

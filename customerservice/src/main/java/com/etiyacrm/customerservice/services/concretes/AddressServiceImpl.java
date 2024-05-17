package com.etiyacrm.customerservice.services.concretes;

import com.etiyacrm.customerservice.core.business.paging.PageInfo;
import com.etiyacrm.customerservice.core.responses.GetListResponse;
import com.etiyacrm.customerservice.entities.Address;
import com.etiyacrm.customerservice.repositories.AddressRepository;
import com.etiyacrm.customerservice.services.abstracts.AddressService;
import com.etiyacrm.customerservice.services.dtos.requests.addressRequests.CreateAddressRequest;
import com.etiyacrm.customerservice.services.dtos.requests.addressRequests.UpdateAddressRequest;
import com.etiyacrm.customerservice.services.dtos.responses.addressResponses.*;
import com.etiyacrm.customerservice.services.mappers.AddressMapper;
import com.etiyacrm.customerservice.services.rules.AddressBusinessRules;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AddressServiceImpl implements AddressService {
    private AddressRepository addressRepository;
    private AddressBusinessRules addressBusinessRules;

    @Override
    public GetListResponse<GetAllAddressResponse> getAll(PageInfo pageInfo) {
        GetListResponse<GetAllAddressResponse> response = new GetListResponse<>();
        Pageable pageable = PageRequest.of(pageInfo.getPage(), pageInfo.getSize());
        Page<Address> addresses = addressRepository.findAllIfDeletedDateIsNull(pageable);
        response.setItems(addresses.stream()
                .map(AddressMapper.INSTANCE::getAllAddressResponseFromAddress).collect(Collectors.toList()));
        response.setTotalElements(addresses.getTotalElements());
        response.setTotalPage(addresses.getTotalPages());
        response.setSize(addresses.getSize());
        response.setHasNext(addresses.hasNext());
        response.setHasPrevious(addresses.hasPrevious());
        return response;
    }

    @Override
    public GetAddressResponse getById(String id) {
        addressBusinessRules.addressNotFound(id);
        addressBusinessRules.addressIsDeleted(id);

        Address foundAddress = addressRepository.findById(id).get();
        GetAddressResponse getAddressResponse = AddressMapper.INSTANCE.getAddressResponseFromAddress(foundAddress);
        return getAddressResponse;
    }

    @Override
    public CreatedAddressResponse add(CreateAddressRequest createAddressRequest) {
        Address address =
                AddressMapper.INSTANCE.addressFromCreateAddressRequest(createAddressRequest);
        address.setCreatedDate(LocalDateTime.now());
        address.setId(UUID.randomUUID().toString());
        Address createdAddress = addressRepository.save(address);
        CreatedAddressResponse createdAddressResponse =
                AddressMapper.INSTANCE.createdAddressResponseFromAddress(createdAddress);
        return createdAddressResponse;
    }

    @Override
    public UpdatedAddressResponse update(UpdateAddressRequest updateAddressRequest, String id) {
        addressBusinessRules.addressNotFound(id);
        addressBusinessRules.addressIsDeleted(id);

        Address foundAddress = addressRepository.findById(id).get();

        Address address =
                AddressMapper.INSTANCE.addressFromUpdateAddressRequest(updateAddressRequest);
        address.setId(foundAddress.getId());
        address.setCreatedDate(foundAddress.getCreatedDate());
        address.setUpdatedDate(LocalDateTime.now());

        Address updatedAddress = addressRepository.save(address);
        UpdatedAddressResponse updatedAddressResponse =
                AddressMapper.INSTANCE.updatedAddressResponseFromAddress(updatedAddress);
        return updatedAddressResponse;
    }

    @Override
    public DeletedAddressResponse delete(String id) {
        addressBusinessRules.addressNotFound(id);
        addressBusinessRules.addressIsDeleted(id);

        Address foundAddress = addressRepository.findById(id).get();
        foundAddress.setDeletedDate(LocalDateTime.now());
        Address deletedAddress = addressRepository.save(foundAddress);

        DeletedAddressResponse deletedAddressResponse =
                AddressMapper.INSTANCE.deletedAddressResponseFromAddress(deletedAddress);
        return deletedAddressResponse;
    }

    @Override
    public List<GetAddressByCustomerIdResponse> getByCustomerId(String customerId) {
        List<Address> addresses = this.addressRepository.findByCustomerId(customerId);
        List<GetAddressByCustomerIdResponse> getAddressByCustomerIdResponse = addresses
                .stream().map(AddressMapper.INSTANCE::getAddressByCustomerIdResponseFromAddress).collect(Collectors.toList());
        return getAddressByCustomerIdResponse;
    }
}

package com.etiya.catalogservice.services.concretes;

import com.etiya.catalogservice.core.business.paging.PageInfo;
import com.etiya.catalogservice.core.responses.GetListResponse;
import com.etiya.catalogservice.entities.Characteristic;
import com.etiya.catalogservice.repositories.CharacteristicRepository;
import com.etiya.catalogservice.services.abstracts.CharacteristicService;
import com.etiya.catalogservice.services.dtos.requests.characteristicRequests.CreateCharacteristicRequest;
import com.etiya.catalogservice.services.dtos.requests.characteristicRequests.UpdateCharacteristicRequest;
import com.etiya.catalogservice.services.dtos.responses.characteristicResponses.*;
import com.etiya.catalogservice.services.mappers.CharacteristicMapper;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CharacteristicServiceImpl implements CharacteristicService {

    private CharacteristicRepository characteristicRepository;

    @Override
    public GetListResponse<GetAllCharacteristicResponse> getAll(PageInfo pageInfo) {
        GetListResponse<GetAllCharacteristicResponse> response = new GetListResponse<>();
        Pageable pageable = PageRequest.of(pageInfo.getPage(), pageInfo.getSize());
        Page<Characteristic> characteristics = characteristicRepository.findAll(pageable);
        response.setItems(characteristics.stream().map(CharacteristicMapper.INSTANCE::getAllCharacteristicResponseFromCharacteristic).collect(Collectors.toList()));
        response.setTotalElements(characteristics.getTotalElements());
        response.setTotalPage(characteristics.getTotalPages());
        response.setSize(characteristics.getSize());
        response.setHasNext(characteristics.hasNext());
        response.setHasPrevious(characteristics.hasPrevious());
        return response;
    }

    @Override
    public GetCharacteristicResponse getById(String id) {
        Characteristic characteristic = characteristicRepository.findById(id).get();
        GetCharacteristicResponse getCharacteristicResponse = CharacteristicMapper.INSTANCE.getCharacteristicResponseFromCharacteristic(characteristic);
        return getCharacteristicResponse;
    }

    @Override
    public CreatedCharacteristicResponse add(CreateCharacteristicRequest createCharacteristicRequest) {
        Characteristic characteristic = CharacteristicMapper.INSTANCE.getCharacteristicFromCreateCharacteristicRequest(createCharacteristicRequest);
        characteristic.setCreatedDate(LocalDateTime.now());
        Characteristic createdCharacteristic = characteristicRepository.save(characteristic);
        return CharacteristicMapper.INSTANCE.getCreatedCharacteristicResponseFromCharacteristic(createdCharacteristic);
    }

    @Override
    public UpdatedCharacteristicResponse update(UpdateCharacteristicRequest updateCharacteristicRequest, String id) {
        Characteristic foundCharacteristic = characteristicRepository.findById(id).get();
        foundCharacteristic.setUpdatedDate(LocalDateTime.now());

        Characteristic characteristic = CharacteristicMapper.INSTANCE.getCharacteristicFromUpdateCharacteristicRequest(updateCharacteristicRequest);
        characteristic.setId(foundCharacteristic.getId());
        characteristic.setCreatedDate(foundCharacteristic.getCreatedDate());
        characteristic.setUpdatedDate(LocalDateTime.now());
        Characteristic updatedCharacteristic = characteristicRepository.save(characteristic);

        UpdatedCharacteristicResponse updatedCharacteristicResponse = CharacteristicMapper.INSTANCE.getUpdatedCharacteristicResponseFromCharacteristic(updatedCharacteristic);
        return updatedCharacteristicResponse;
    }

    @Override
    public DeletedCharacteristicResponse delete(String id) {
        Characteristic foundCharacteristic = characteristicRepository.findById(id).get();
        foundCharacteristic.setDeletedDate(LocalDateTime.now());
        Characteristic deletedCharacteristic = characteristicRepository.save(foundCharacteristic);
        DeletedCharacteristicResponse deletedCharacteristicResponse = CharacteristicMapper.INSTANCE.getDeletedCharacteristicResponseFromCharacteristic(deletedCharacteristic);
        return deletedCharacteristicResponse;
    }
}

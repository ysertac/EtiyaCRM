package com.etiya.catalogservice.services.concretes;

import com.etiya.catalogservice.core.business.paging.PageInfo;
import com.etiya.catalogservice.core.responses.GetListResponse;
import com.etiya.catalogservice.entities.CharacteristicValue;
import com.etiya.catalogservice.repositories.CharacteristicValueRepository;
import com.etiya.catalogservice.services.abstracts.CharacteristicValueService;
import com.etiya.catalogservice.services.dtos.requests.characteristicValueRequests.CreateCharacteristicValueRequest;
import com.etiya.catalogservice.services.dtos.requests.characteristicValueRequests.UpdateCharacteristicValueRequest;
import com.etiya.catalogservice.services.dtos.responses.characteristicValueResponses.*;
import com.etiya.catalogservice.services.mappers.CharacteristicValueMapper;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CharacteristicValueServiceImpl implements CharacteristicValueService {

    private CharacteristicValueRepository characteristicValueRepository;

    @Override
    public GetListResponse<GetAllCharacteristicValueResponse> getAll(PageInfo pageInfo) {
        GetListResponse<GetAllCharacteristicValueResponse> response = new GetListResponse<>();
        Pageable pageable = PageRequest.of(pageInfo.getPage(), pageInfo.getSize());
        Page<CharacteristicValue> characteristicValues = characteristicValueRepository.findAll(pageable);
        response.setItems(characteristicValues.stream().map(CharacteristicValueMapper.INSTANCE::getAllCharacteristicValueResponseFromCharacteristicValue).collect(Collectors.toList()));
        response.setTotalElements(characteristicValues.getTotalElements());
        response.setTotalPage(characteristicValues.getTotalPages());
        response.setSize(characteristicValues.getSize());
        response.setHasNext(characteristicValues.hasNext());
        response.setHasPrevious(characteristicValues.hasPrevious());
        return response;
    }

    @Override
    public GetCharacteristicValueResponse getById(String id) {
        CharacteristicValue characteristicValue = characteristicValueRepository.findById(id).get();
        GetCharacteristicValueResponse getCharacteristicValueResponse = CharacteristicValueMapper.INSTANCE.getCharacteristicValueResponseFromCharacteristicValue(characteristicValue);
        return getCharacteristicValueResponse;
    }

    @Override
    public CreatedCharacteristicValueResponse add(CreateCharacteristicValueRequest createCharacteristicValueRequest) {
        CharacteristicValue characteristicValue = CharacteristicValueMapper.INSTANCE.getCharacteristicValueFromCreateCharacteristicValueRequest(createCharacteristicValueRequest);
        characteristicValue.setCreatedDate(LocalDateTime.now());
        CharacteristicValue createdCharacteristicValue = characteristicValueRepository.save(characteristicValue);
        return CharacteristicValueMapper.INSTANCE.getCreatedCharacteristicValueResponseFromCharacteristicValue(createdCharacteristicValue);
    }

    @Override
    public UpdatedCharacteristicValueResponse update(UpdateCharacteristicValueRequest updateCharacteristicValueRequest, String id) {
        CharacteristicValue foundCharacteristicValue = characteristicValueRepository.findById(id).get();
        foundCharacteristicValue.setUpdatedDate(LocalDateTime.now());

        CharacteristicValue characteristicValue = CharacteristicValueMapper.INSTANCE.getCharacteristicValueFromUpdateCharacteristicValueRequest(updateCharacteristicValueRequest);
        characteristicValue.setId(foundCharacteristicValue.getId());
        characteristicValue.setCreatedDate(foundCharacteristicValue.getCreatedDate());
        characteristicValue.setUpdatedDate(LocalDateTime.now());
        CharacteristicValue updatedCharacteristicValue = characteristicValueRepository.save(characteristicValue);

        UpdatedCharacteristicValueResponse updatedCharacteristicValueResponse = CharacteristicValueMapper.INSTANCE.getUpdatedCharacteristicValueResponseFromCharacteristicValue(updatedCharacteristicValue);
        return updatedCharacteristicValueResponse;
    }

    @Override
    public DeletedCharacteristicValueResponse delete(String id) {
        CharacteristicValue foundCharacteristicValue = characteristicValueRepository.findById(id).get();
        foundCharacteristicValue.setDeletedDate(LocalDateTime.now());
        CharacteristicValue deletedCharacteristicValue = characteristicValueRepository.save(foundCharacteristicValue);
        DeletedCharacteristicValueResponse deletedCharacteristicValueResponse = CharacteristicValueMapper.INSTANCE.getDeletedCharacteristicValueResponseFromCharacteristicValue(deletedCharacteristicValue);
        return deletedCharacteristicValueResponse;
    }
}

package com.etiya.catalogservice.services.mappers;

import com.etiya.catalogservice.entities.CharacteristicValue;
import com.etiya.catalogservice.services.dtos.requests.characteristicValueRequests.CreateCharacteristicValueRequest;
import com.etiya.catalogservice.services.dtos.requests.characteristicValueRequests.UpdateCharacteristicValueRequest;
import com.etiya.catalogservice.services.dtos.responses.characteristicValueResponses.*;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CharacteristicValueMapper {
    CharacteristicValueMapper INSTANCE = Mappers.getMapper(CharacteristicValueMapper.class);

    GetAllCharacteristicValueResponse getAllCharacteristicValueResponseFromCharacteristicValue(CharacteristicValue characteristicValue);

    GetCharacteristicValueResponse getCharacteristicValueResponseFromCharacteristicValue(CharacteristicValue characteristicValue);

    CharacteristicValue getCharacteristicValueFromCreateCharacteristicValueRequest(CreateCharacteristicValueRequest createCharacteristicValueRequest);

    CreatedCharacteristicValueResponse getCreatedCharacteristicValueResponseFromCharacteristicValue(CharacteristicValue characteristicValue);

    CharacteristicValue getCharacteristicValueFromUpdateCharacteristicValueRequest(UpdateCharacteristicValueRequest updateCharacteristicValueRequest);

    UpdatedCharacteristicValueResponse getUpdatedCharacteristicValueResponseFromCharacteristicValue(CharacteristicValue characteristicValue);

    DeletedCharacteristicValueResponse getDeletedCharacteristicValueResponseFromCharacteristicValue(CharacteristicValue characteristicValue);
}

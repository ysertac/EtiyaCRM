package com.etiya.catalogservice.services.mappers;

import com.etiya.catalogservice.entities.CharacteristicValue;
import com.etiya.catalogservice.services.dtos.requests.characteristicValueRequests.CreateCharacteristicValueRequest;
import com.etiya.catalogservice.services.dtos.requests.characteristicValueRequests.UpdateCharacteristicValueRequest;
import com.etiya.catalogservice.services.dtos.responses.characteristicValueResponses.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CharacteristicValueMapper {
    CharacteristicValueMapper INSTANCE = Mappers.getMapper(CharacteristicValueMapper.class);
    
    @Mapping(source = "characteristicValue.characteristic.id", target = "characteristicId")
    GetAllCharacteristicValueResponse getAllCharacteristicValueResponseFromCharacteristicValue(CharacteristicValue characteristicValue);

    @Mapping(source = "characteristic.id", target = "characteristicId")
    GetCharacteristicValueResponse getCharacteristicValueResponseFromCharacteristicValue(CharacteristicValue characteristicValue);

    @Mapping(source = "characteristicId", target = "characteristic.id")
    CharacteristicValue getCharacteristicValueFromCreateCharacteristicValueRequest(CreateCharacteristicValueRequest createCharacteristicValueRequest);

    @Mapping(source = "characteristic.id", target = "characteristicId")
    CreatedCharacteristicValueResponse getCreatedCharacteristicValueResponseFromCharacteristicValue(CharacteristicValue characteristicValue);

    @Mapping(source = "characteristicId", target = "characteristic.id")
    CharacteristicValue getCharacteristicValueFromUpdateCharacteristicValueRequest(UpdateCharacteristicValueRequest updateCharacteristicValueRequest);

    @Mapping(source = "characteristic.id", target = "characteristicId")
    UpdatedCharacteristicValueResponse getUpdatedCharacteristicValueResponseFromCharacteristicValue(CharacteristicValue characteristicValue);

    DeletedCharacteristicValueResponse getDeletedCharacteristicValueResponseFromCharacteristicValue(CharacteristicValue characteristicValue);
}

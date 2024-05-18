package com.etiya.catalogservice.services.mappers;

import com.etiya.catalogservice.entities.Characteristic;
import com.etiya.catalogservice.services.dtos.requests.characteristicRequests.CreateCharacteristicRequest;
import com.etiya.catalogservice.services.dtos.requests.characteristicRequests.UpdateCharacteristicRequest;
import com.etiya.catalogservice.services.dtos.responses.characteristicResponses.*;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CharacteristicMapper {
    CharacteristicMapper INSTANCE = Mappers.getMapper(CharacteristicMapper.class);

    GetAllCharacteristicResponse getAllCharacteristicResponseFromCharacteristic(Characteristic characteristic);

    GetCharacteristicResponse getCharacteristicResponseFromCharacteristic(Characteristic characteristic);

    Characteristic getCharacteristicFromCreateCharacteristicRequest(CreateCharacteristicRequest createCharacteristicRequest);

    CreatedCharacteristicResponse getCreatedCharacteristicResponseFromCharacteristic(Characteristic characteristic);

    Characteristic getCharacteristicFromUpdateCharacteristicRequest(UpdateCharacteristicRequest updateCharacteristicRequest);

    UpdatedCharacteristicResponse getUpdatedCharacteristicResponseFromCharacteristic(Characteristic characteristic);

    DeletedCharacteristicResponse getDeletedCharacteristicResponseFromCharacteristic(Characteristic characteristic);
}

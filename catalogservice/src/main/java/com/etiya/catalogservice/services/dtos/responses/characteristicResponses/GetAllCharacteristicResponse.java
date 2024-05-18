package com.etiya.catalogservice.services.dtos.responses.characteristicResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllCharacteristicResponse {
    private String id;
    private String name;
    private String description;
}
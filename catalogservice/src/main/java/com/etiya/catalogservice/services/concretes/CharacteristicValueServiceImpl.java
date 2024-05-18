package com.etiya.catalogservice.services.concretes;

import com.etiya.catalogservice.core.business.paging.PageInfo;
import com.etiya.catalogservice.core.responses.GetListResponse;
import com.etiya.catalogservice.repositories.CharacteristicValueRepository;
import com.etiya.catalogservice.services.abstracts.CharacteristicValueService;
import com.etiya.catalogservice.services.dtos.requests.characteristicValueRequests.CreateCharacteristicValueRequest;
import com.etiya.catalogservice.services.dtos.requests.characteristicValueRequests.UpdateCharacteristicValueRequest;
import com.etiya.catalogservice.services.dtos.responses.characteristicValueResponses.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CharacteristicValueServiceImpl implements CharacteristicValueService {

    private CharacteristicValueRepository characteristicValueRepository;

    @Override
    public GetListResponse<GetAllCharacteristicValueResponse> getAll(PageInfo pageInfo) {
        return null;
    }

    @Override
    public GetCharacteristicValueResponse getById(String id) {
        return null;
    }

    @Override
    public CreatedCharacteristicValueResponse add(CreateCharacteristicValueRequest createCharacteristicValueRequest) {
        return null;
    }

    @Override
    public UpdatedCharacteristicValueResponse update(UpdateCharacteristicValueRequest updateCharacteristicValueRequest, String id) {
        return null;
    }

    @Override
    public DeletedCharacteristicValueResponse delete(String id) {
        return null;
    }
}

package com.etiya.catalogservice.services.concretes;

import com.etiya.catalogservice.core.business.paging.PageInfo;
import com.etiya.catalogservice.core.responses.GetListResponse;
import com.etiya.catalogservice.repositories.CharacteristicRepository;
import com.etiya.catalogservice.services.abstracts.CharacteristicService;
import com.etiya.catalogservice.services.dtos.requests.characteristicRequests.CreateCharacteristicRequest;
import com.etiya.catalogservice.services.dtos.requests.characteristicRequests.UpdateCharacteristicRequest;
import com.etiya.catalogservice.services.dtos.responses.characteristicResponses.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CharacteristicServiceImpl implements CharacteristicService {

    private CharacteristicRepository characteristicRepository;

    @Override
    public GetListResponse<GetAllCharacteristicResponse> getAll(PageInfo pageInfo) {
        return null;
    }

    @Override
    public GetCharacteristicResponse getById(String id) {
        return null;
    }

    @Override
    public CreatedCharacteristicResponse add(CreateCharacteristicRequest createCharacteristicRequest) {
        return null;
    }

    @Override
    public UpdatedCharacteristicResponse update(UpdateCharacteristicRequest updateCharacteristicRequest, String id) {
        return null;
    }

    @Override
    public DeletedCharacteristicResponse delete(String id) {
        return null;
    }
}

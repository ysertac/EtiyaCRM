package com.etiya.catalogservice.services.abstracts;

import com.etiya.catalogservice.core.business.paging.PageInfo;
import com.etiya.catalogservice.core.responses.GetListResponse;
import com.etiya.catalogservice.services.dtos.requests.characteristicRequests.CreateCharacteristicRequest;
import com.etiya.catalogservice.services.dtos.requests.characteristicRequests.UpdateCharacteristicRequest;
import com.etiya.catalogservice.services.dtos.responses.characteristicResponses.*;

public interface CharacteristicService {

    GetListResponse<GetAllCharacteristicResponse> getAll(PageInfo pageInfo);

    GetCharacteristicResponse getById(String id);

    CreatedCharacteristicResponse add(CreateCharacteristicRequest createCharacteristicRequest);

    UpdatedCharacteristicResponse update(UpdateCharacteristicRequest updateCharacteristicRequest, String id);

    DeletedCharacteristicResponse delete(String id);
}

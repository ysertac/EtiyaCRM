package com.etiya.catalogservice.services.abstracts;

import com.etiya.catalogservice.core.business.paging.PageInfo;
import com.etiya.catalogservice.core.responses.GetListResponse;
import com.etiya.catalogservice.services.dtos.requests.characteristicValueRequests.CreateCharacteristicValueRequest;
import com.etiya.catalogservice.services.dtos.requests.characteristicValueRequests.UpdateCharacteristicValueRequest;
import com.etiya.catalogservice.services.dtos.responses.characteristicValueResponses.*;

public interface CharacteristicValueService {

    GetListResponse<GetAllCharacteristicValueResponse> getAll(PageInfo pageInfo);

    GetCharacteristicValueResponse getById(String id);

    CreatedCharacteristicValueResponse add(CreateCharacteristicValueRequest createCharacteristicValueRequest);

    UpdatedCharacteristicValueResponse update(UpdateCharacteristicValueRequest updateCharacteristicValueRequest, String id);

    DeletedCharacteristicValueResponse delete(String id);
}

package com.etiyacrm.customerservice.services.abstracts;

import com.etiyacrm.customerservice.core.business.paging.PageInfo;
import com.etiyacrm.customerservice.core.responses.GetListResponse;
import com.etiyacrm.customerservice.services.dtos.requests.cityRequests.CreateCityRequest;
import com.etiyacrm.customerservice.services.dtos.requests.cityRequests.UpdateCityRequest;
import com.etiyacrm.customerservice.services.dtos.responses.CityResponses.*;

import java.util.List;

public interface CityService {
    GetListResponse<GetAllCityResponse> getAll(PageInfo pageInfo);
    GetCityResponse getById(String id);
    CreatedCityResponse add(CreateCityRequest createCityRequest);
    UpdatedCityResponse update(UpdateCityRequest updateCityRequest, String id);
    DeletedCityResponse delete(String id);
    List<GetCityByCountryIdResponse> getByCountryId(String countryId);
}

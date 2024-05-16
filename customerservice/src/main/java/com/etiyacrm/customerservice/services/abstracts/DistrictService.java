package com.etiyacrm.customerservice.services.abstracts;

import com.etiyacrm.customerservice.core.business.paging.PageInfo;
import com.etiyacrm.customerservice.core.responses.GetListResponse;
import com.etiyacrm.customerservice.services.dtos.requests.cityRequests.CreateCityRequest;
import com.etiyacrm.customerservice.services.dtos.requests.cityRequests.UpdateCityRequest;
import com.etiyacrm.customerservice.services.dtos.requests.districtRequests.CreateDistrictRequest;
import com.etiyacrm.customerservice.services.dtos.requests.districtRequests.UpdateDistrictRequest;
import com.etiyacrm.customerservice.services.dtos.responses.CityResponses.*;
import com.etiyacrm.customerservice.services.dtos.responses.districtResponses.*;

import java.util.List;

public interface DistrictService {
    List<GetAllDistrictResponse> getAll();
    GetDistrictResponse getById(String id);
    CreatedDistrictResponse add(CreateDistrictRequest createDistrictRequest);
    UpdatedDistrictResponse update(UpdateDistrictRequest updateDistrictRequest, String id);
    DeletedDistrictResponse delete(String id);
    List<GetDistrictByCityIdResponse> getByCityId(String cityId);
}

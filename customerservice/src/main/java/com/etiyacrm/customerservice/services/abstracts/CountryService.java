package com.etiyacrm.customerservice.services.abstracts;


import com.etiyacrm.customerservice.services.dtos.requests.countryRequests.CreateCountryRequest;
import com.etiyacrm.customerservice.services.dtos.requests.countryRequests.UpdateCountryRequest;
import com.etiyacrm.customerservice.services.dtos.responses.CountryResponses.*;

import java.util.List;

public interface CountryService {
    List<GetAllCountryResponse> getAll();
    GetCountryResponse getById(String id);
    CreatedCountryResponse add(CreateCountryRequest createCountryRequest);
    UpdatedCountryResponse update(UpdateCountryRequest updateCountryRequest, String id);
    DeletedCountryResponse delete(String id);
}

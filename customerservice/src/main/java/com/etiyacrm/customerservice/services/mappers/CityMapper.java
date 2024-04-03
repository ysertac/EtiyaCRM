package com.etiyacrm.customerservice.services.mappers;

import com.etiyacrm.customerservice.entities.City;
import com.etiyacrm.customerservice.services.dtos.requests.cityRequests.CreateCityRequest;
import com.etiyacrm.customerservice.services.dtos.responses.CityResponses.CreatedCityResponse;
import com.etiyacrm.customerservice.services.dtos.responses.CityResponses.GetAllCityResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CityMapper {
    CityMapper INSTANCE = Mappers.getMapper(CityMapper.class);

    GetAllCityResponse getAllCityResponseFromCity(City city);
    City cityFromCreateCityRequest(CreateCityRequest createCityRequest);
    CreatedCityResponse createdCityResponseFromCity(City city);
}

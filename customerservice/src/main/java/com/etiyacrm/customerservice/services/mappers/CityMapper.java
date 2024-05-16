package com.etiyacrm.customerservice.services.mappers;

import com.etiyacrm.customerservice.entities.Address;
import com.etiyacrm.customerservice.entities.City;
import com.etiyacrm.customerservice.services.dtos.requests.cityRequests.CreateCityRequest;
import com.etiyacrm.customerservice.services.dtos.requests.cityRequests.UpdateCityRequest;
import com.etiyacrm.customerservice.services.dtos.responses.CityResponses.*;
import com.etiyacrm.customerservice.services.dtos.responses.addressResponses.GetAddressByCustomerIdResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CityMapper {
    CityMapper INSTANCE = Mappers.getMapper(CityMapper.class);
    @Mapping(source = "city.country.id", target = "countryId")
    GetAllCityResponse getAllCityResponseFromCity(City city);
    @Mapping(source = "city.country.id", target = "countryId")
    GetCityResponse getCityResponseFromCity(City city);
    @Mapping(source = "createCityRequest.countryId", target = "country.id")
    City cityFromCreateCityRequest(CreateCityRequest createCityRequest);
    @Mapping(source = "city.country.id", target = "countryId")
    CreatedCityResponse createdCityResponseFromCity(City city);
    @Mapping(source = "updateCityRequest.countryId", target = "country.id")
    City cityFromUpdateCityRequest(UpdateCityRequest updateCityRequest);
    @Mapping(source = "city.country.id", target = "countryId")
    UpdatedCityResponse updatedCityResponseFromCity(City city);
    @Mapping(source = "city.country.id", target = "countryId")
    DeletedCityResponse deletedCityResponseFromCity(City city);
    @Mapping(source = "city.country.id", target = "countryId")
    GetCityByCountryIdResponse getCityByCountryIdResponseFromCity(City city);
}

package com.etiyacrm.customerservice.services.mappers;


import com.etiyacrm.customerservice.entities.Country;
import com.etiyacrm.customerservice.services.dtos.requests.countryRequests.CreateCountryRequest;
import com.etiyacrm.customerservice.services.dtos.requests.countryRequests.UpdateCountryRequest;
import com.etiyacrm.customerservice.services.dtos.responses.CountryResponses.*;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CountryMapper {
    CountryMapper INSTANCE = Mappers.getMapper(CountryMapper.class);

    GetAllCountryResponse getAllCountryResponseFromCountry(Country country);
    GetCountryResponse getCountryResponseFromCountry(Country country);
    Country countryFromCreateCountryRequest(CreateCountryRequest createCountryRequest);
    CreatedCountryResponse createdCountryResponseFromCountry(Country country);
    Country countryFromUpdateCountryRequest(UpdateCountryRequest updateCountryRequest);
    UpdatedCountryResponse updatedCountryResponseFromCountry(Country country);
    DeletedCountryResponse deletedCountryResponseFromCountry(Country country);
}

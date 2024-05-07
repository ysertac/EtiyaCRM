package com.etiyacrm.customerservice.services.mappers;

import com.etiyacrm.customerservice.entities.City;
import com.etiyacrm.customerservice.services.dtos.requests.cityRequests.CreateCityRequest;
import com.etiyacrm.customerservice.services.dtos.requests.cityRequests.UpdateCityRequest;
import com.etiyacrm.customerservice.services.dtos.responses.CityResponses.CreatedCityResponse;
import com.etiyacrm.customerservice.services.dtos.responses.CityResponses.DeletedCityResponse;
import com.etiyacrm.customerservice.services.dtos.responses.CityResponses.GetAllCityResponse;
import com.etiyacrm.customerservice.services.dtos.responses.CityResponses.GetCityResponse;
import com.etiyacrm.customerservice.services.dtos.responses.CityResponses.UpdatedCityResponse;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-05T00:25:58-0700",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.10 (Amazon.com Inc.)"
)
public class CityMapperImpl implements CityMapper {

    @Override
    public GetAllCityResponse getAllCityResponseFromCity(City city) {
        if ( city == null ) {
            return null;
        }

        GetAllCityResponse getAllCityResponse = new GetAllCityResponse();

        getAllCityResponse.setId( city.getId() );
        getAllCityResponse.setName( city.getName() );

        return getAllCityResponse;
    }

    @Override
    public GetCityResponse getCityResponseFromCity(City city) {
        if ( city == null ) {
            return null;
        }

        GetCityResponse getCityResponse = new GetCityResponse();

        getCityResponse.setId( city.getId() );
        getCityResponse.setName( city.getName() );

        return getCityResponse;
    }

    @Override
    public City cityFromCreateCityRequest(CreateCityRequest createCityRequest) {
        if ( createCityRequest == null ) {
            return null;
        }

        City city = new City();

        city.setName( createCityRequest.getName() );

        return city;
    }

    @Override
    public CreatedCityResponse createdCityResponseFromCity(City city) {
        if ( city == null ) {
            return null;
        }

        CreatedCityResponse createdCityResponse = new CreatedCityResponse();

        createdCityResponse.setId( city.getId() );
        createdCityResponse.setName( city.getName() );

        return createdCityResponse;
    }

    @Override
    public City cityFromUpdateCityRequest(UpdateCityRequest updateCityRequest) {
        if ( updateCityRequest == null ) {
            return null;
        }

        City city = new City();

        city.setName( updateCityRequest.getName() );

        return city;
    }

    @Override
    public UpdatedCityResponse updatedCityResponseFromCity(City city) {
        if ( city == null ) {
            return null;
        }

        UpdatedCityResponse updatedCityResponse = new UpdatedCityResponse();

        updatedCityResponse.setId( city.getId() );
        updatedCityResponse.setName( city.getName() );

        return updatedCityResponse;
    }

    @Override
    public DeletedCityResponse deletedCityResponseFromCity(City city) {
        if ( city == null ) {
            return null;
        }

        DeletedCityResponse deletedCityResponse = new DeletedCityResponse();

        deletedCityResponse.setId( city.getId() );
        deletedCityResponse.setName( city.getName() );

        return deletedCityResponse;
    }
}

package com.etiyacrm.customerservice.services.concretes;

import com.etiyacrm.customerservice.core.business.paging.PageInfo;
import com.etiyacrm.customerservice.core.responses.GetListResponse;
import com.etiyacrm.customerservice.entities.Address;
import com.etiyacrm.customerservice.entities.City;
import com.etiyacrm.customerservice.repositories.CityRepository;
import com.etiyacrm.customerservice.services.dtos.requests.cityRequests.UpdateCityRequest;
import com.etiyacrm.customerservice.services.dtos.responses.CityResponses.*;
import com.etiyacrm.customerservice.services.dtos.responses.addressResponses.GetAddressByCustomerIdResponse;
import com.etiyacrm.customerservice.services.mappers.AddressMapper;
import com.etiyacrm.customerservice.services.mappers.CityMapper;
import com.etiyacrm.customerservice.services.abstracts.CityService;
import com.etiyacrm.customerservice.services.dtos.requests.cityRequests.CreateCityRequest;
import com.etiyacrm.customerservice.services.rules.CityBusinessRules;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CityServiceImpl implements CityService {
    private CityRepository cityRepository;
    private CityBusinessRules cityBusinessRules;

    @Override
    public GetListResponse<GetAllCityResponse> getAll(PageInfo pageInfo) {
        GetListResponse<GetAllCityResponse> response = new GetListResponse<>();
        Pageable pageable = PageRequest.of(pageInfo.getPage(), pageInfo.getSize());
        Page<City> cities = cityRepository.findAllIfDeletedDateIsNull(pageable);
        response.setItems(cities.stream().map(CityMapper.INSTANCE::getAllCityResponseFromCity).collect(Collectors.toList()));
        response.setTotalElements(cities.getTotalElements());
        response.setTotalPage(cities.getTotalPages());
        response.setSize(cities.getSize());
        response.setHasNext(cities.hasNext());
        response.setHasPrevious(cities.hasPrevious());
        return response;
    }

    @Override
    public GetCityResponse getById(String id) {
        cityBusinessRules.cityNotFound(id);
        cityBusinessRules.cityIsDeleted(id);

        City foundCity = cityRepository.findById(id).get();
        GetCityResponse getCityResponse = CityMapper.INSTANCE.getCityResponseFromCity(foundCity);
        return getCityResponse;
    } // d

    @Override
    public CreatedCityResponse add(CreateCityRequest createCityRequest) {
        cityBusinessRules.cityNameCanNotBeDuplicated(createCityRequest.getName());

        City city = CityMapper.INSTANCE.cityFromCreateCityRequest(createCityRequest);
        city.setId(UUID.randomUUID().toString());
        city.setCreatedDate(LocalDateTime.now());
        City createdCity = cityRepository.save(city);

        CreatedCityResponse createdCityResponse = CityMapper.INSTANCE.createdCityResponseFromCity(createdCity);
        return createdCityResponse;
    }

    public UpdatedCityResponse update(UpdateCityRequest updateCityRequest, String id) {
        cityBusinessRules.cityNotFound(id);
        cityBusinessRules.cityIsDeleted(id);
        cityBusinessRules.cityNameCanNotBeDuplicated(updateCityRequest.getName());

        City foundCity = cityRepository.findById(id).get();
        foundCity.setUpdatedDate(LocalDateTime.now());

        City city = CityMapper.INSTANCE.cityFromUpdateCityRequest(updateCityRequest);
        city.setId(foundCity.getId());
        city.setCreatedDate(foundCity.getCreatedDate());
        city.setUpdatedDate(foundCity.getUpdatedDate());
        City updatedCity = cityRepository.save(city);

        UpdatedCityResponse updatedCityResponse = CityMapper.INSTANCE.updatedCityResponseFromCity(updatedCity);
        return updatedCityResponse;
    }

    public DeletedCityResponse delete(String id) {
        cityBusinessRules.cityNotFound(id);
        cityBusinessRules.cityIsDeleted(id);

        City foundCity = cityRepository.findById(id).get();
        foundCity.setDeletedDate(LocalDateTime.now());
        City deletedCity = cityRepository.save(foundCity);

        DeletedCityResponse deletedCityResponse = CityMapper.INSTANCE.deletedCityResponseFromCity(deletedCity);
        return deletedCityResponse;
    }

    @Override
    public List<GetCityByCountryIdResponse> getByCountryId(String countryId) {
        List<City> cities = this.cityRepository.findByCountryId(countryId);
        List<GetCityByCountryIdResponse> getCityByCountryIdResponse = cities
                .stream().map(CityMapper.INSTANCE::getCityByCountryIdResponseFromCity).collect(Collectors.toList());
        return getCityByCountryIdResponse;
    }
}

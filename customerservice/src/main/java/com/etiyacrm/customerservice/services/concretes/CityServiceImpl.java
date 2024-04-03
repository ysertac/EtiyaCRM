package com.etiyacrm.customerservice.services.concretes;

import com.etiyacrm.customerservice.core.business.paging.PageInfo;
import com.etiyacrm.customerservice.entities.City;
import com.etiyacrm.customerservice.repositories.CityRepository;
import com.etiyacrm.customerservice.services.mappers.CityMapper;
import com.etiyacrm.customerservice.services.abstracts.CityService;
import com.etiyacrm.customerservice.services.dtos.requests.cityRequests.CreateCityRequest;
import com.etiyacrm.customerservice.services.dtos.responses.CityResponses.CreatedCityResponse;
import com.etiyacrm.customerservice.services.dtos.responses.CityResponses.GetAllCityResponse;
import com.etiyacrm.customerservice.services.rules.CityBusinessRules;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CityServiceImpl implements CityService {
    private CityRepository cityRepository;
    private CityBusinessRules cityBusinessRules;

    @Override
    public List<GetAllCityResponse> getAll(PageInfo pageInfo) {
        Pageable pageable = PageRequest.of(pageInfo.getPage(), pageInfo.getSize());
        Page<City> response = cityRepository.findAll(pageable);
        List<GetAllCityResponse> getAllCityResponse = response.map(city -> CityMapper.INSTANCE.getAllCityResponseFromCity(city)).getContent();
        return getAllCityResponse;
    }

    @Override
    public CreatedCityResponse add(CreateCityRequest createCityRequest) {
        cityBusinessRules.CityNameCanNotBeDuplicatedWhenInserted(createCityRequest.getName());

        City city = CityMapper.INSTANCE.cityFromCreateCityRequest(createCityRequest);
        City createdCity = cityRepository.save(city);

        CreatedCityResponse createdCityResponse = CityMapper.INSTANCE.createdCityResponseFromCity(createdCity);
        return createdCityResponse;
    }
}

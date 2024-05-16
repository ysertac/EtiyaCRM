package com.etiyacrm.customerservice.services.concretes;

import com.etiyacrm.customerservice.entities.Country;
import com.etiyacrm.customerservice.entities.District;
import com.etiyacrm.customerservice.repositories.CountryRepository;
import com.etiyacrm.customerservice.repositories.DistrictRepository;
import com.etiyacrm.customerservice.services.abstracts.CountryService;
import com.etiyacrm.customerservice.services.dtos.requests.countryRequests.CreateCountryRequest;
import com.etiyacrm.customerservice.services.dtos.requests.countryRequests.UpdateCountryRequest;
import com.etiyacrm.customerservice.services.dtos.responses.CountryResponses.*;
import com.etiyacrm.customerservice.services.dtos.responses.districtResponses.*;
import com.etiyacrm.customerservice.services.mappers.CountryMapper;
import com.etiyacrm.customerservice.services.mappers.DistrictMapper;
import com.etiyacrm.customerservice.services.rules.CountryBusinessRules;
import com.etiyacrm.customerservice.services.rules.DistrictBusinessRules;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CountryServiceImpl implements CountryService {

    private CountryRepository countryRepository;
    private CountryBusinessRules countryBusinessRules;

    @Override
    public List<GetAllCountryResponse> getAll() {
        List<Country> countries = countryRepository.findAllIfDeletedDateIsNull();
        List<GetAllCountryResponse> getAllCountryResponse = countries.stream()
                .map(CountryMapper.INSTANCE::getAllCountryResponseFromCountry).collect(Collectors.toList());
        return getAllCountryResponse;
    }

    @Override
    public GetCountryResponse getById(String id) {
        countryBusinessRules.countryNotFound(id);
        countryBusinessRules.countryIsDeleted(id);
        Country foundCountry = countryRepository.findById(id).get();
        GetCountryResponse getCountryResponse = CountryMapper.INSTANCE.getCountryResponseFromCountry(foundCountry);
        return getCountryResponse;
    }

    @Override
    public CreatedCountryResponse add(CreateCountryRequest createCountryRequest) {
        countryBusinessRules.countryNameCanNotBeDuplicated(createCountryRequest.getName());
        Country country = CountryMapper.INSTANCE.countryFromCreateCountryRequest(createCountryRequest);
        country.setId(UUID.randomUUID().toString());
        country.setCreatedDate(LocalDateTime.now());
        Country createdCountry = countryRepository.save(country);

        CreatedCountryResponse createdCountryResponse = CountryMapper.INSTANCE.createdCountryResponseFromCountry(createdCountry);
        return createdCountryResponse;
    }

    @Override
    public UpdatedCountryResponse update(UpdateCountryRequest updateCountryRequest, String id) {
        countryBusinessRules.countryNotFound(id);
        countryBusinessRules.countryIsDeleted(id);
        countryBusinessRules.countryNameCanNotBeDuplicated(updateCountryRequest.getName());
        Country foundCountry = countryRepository.findById(id).get();
        foundCountry.setUpdatedDate(LocalDateTime.now());

        Country country = CountryMapper.INSTANCE.countryFromUpdateCountryRequest(updateCountryRequest);
        country.setId(foundCountry.getId());
        country.setCreatedDate(foundCountry.getCreatedDate());
        country.setUpdatedDate(foundCountry.getUpdatedDate());
        Country updatedCountry = countryRepository.save(country);

        UpdatedCountryResponse updatedCountryResponse = CountryMapper.INSTANCE.updatedCountryResponseFromCountry(updatedCountry);
        return updatedCountryResponse;
    }

    @Override
    public DeletedCountryResponse delete(String id) {
        countryBusinessRules.countryNotFound(id);
        countryBusinessRules.countryIsDeleted(id);
        Country foundCountry = countryRepository.findById(id).get();
        foundCountry.setDeletedDate(LocalDateTime.now());
        Country deletedCountry = countryRepository.save(foundCountry);

        DeletedCountryResponse deletedCountryResponse = CountryMapper.INSTANCE.deletedCountryResponseFromCountry(deletedCountry);
        return deletedCountryResponse;
    }
}

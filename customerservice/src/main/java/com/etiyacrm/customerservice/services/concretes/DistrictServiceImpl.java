package com.etiyacrm.customerservice.services.concretes;

import com.etiyacrm.customerservice.entities.City;
import com.etiyacrm.customerservice.entities.District;
import com.etiyacrm.customerservice.repositories.DistrictRepository;
import com.etiyacrm.customerservice.services.abstracts.DistrictService;
import com.etiyacrm.customerservice.services.dtos.requests.districtRequests.CreateDistrictRequest;
import com.etiyacrm.customerservice.services.dtos.requests.districtRequests.UpdateDistrictRequest;

import com.etiyacrm.customerservice.services.dtos.responses.CityResponses.GetCityByCountryIdResponse;
import com.etiyacrm.customerservice.services.dtos.responses.districtResponses.*;
import com.etiyacrm.customerservice.services.mappers.CityMapper;
import com.etiyacrm.customerservice.services.mappers.DistrictMapper;
import com.etiyacrm.customerservice.services.rules.DistrictBusinessRules;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DistrictServiceImpl implements DistrictService {
    private DistrictRepository districtRepository;
    private DistrictBusinessRules districtBusinessRules;

    @Override
    public List<GetAllDistrictResponse> getAll() {
        List<District> districts = districtRepository.findAllIfDeletedDateIsNull();
        List<GetAllDistrictResponse> getAllDistrictResponse = districts.stream()
                .map(DistrictMapper.INSTANCE::getAllDistrictResponseFromDistrict).collect(Collectors.toList());
        return getAllDistrictResponse;
    }

    @Override
    public GetDistrictResponse getById(String id) {
        districtBusinessRules.districtNotFound(id);
        districtBusinessRules.districtIsDeleted(id);
        District foundDistrict = districtRepository.findById(id).get();
        GetDistrictResponse getDistrictResponse = DistrictMapper.INSTANCE.getDistrictResponseFromDistrict(foundDistrict);
        return getDistrictResponse;
    }

    @Override
    public CreatedDistrictResponse add(CreateDistrictRequest createDistrictRequest) {
        districtBusinessRules.districtNameCanNotBeDuplicated(createDistrictRequest.getName());
        District district = DistrictMapper.INSTANCE.districtFromCreateDistrictRequest(createDistrictRequest);
        district.setId(UUID.randomUUID().toString());
        district.setCreatedDate(LocalDateTime.now());
        District createdDistrict = districtRepository.save(district);

        CreatedDistrictResponse createdDistrictResponse = DistrictMapper.INSTANCE.createdDistrictResponseFromDistrict(createdDistrict);
        return createdDistrictResponse;
    }

    @Override
    public UpdatedDistrictResponse update(UpdateDistrictRequest updateDistrictRequest, String id) {
        districtBusinessRules.districtNotFound(id);
        districtBusinessRules.districtIsDeleted(id);
        districtBusinessRules.districtNameCanNotBeDuplicated(updateDistrictRequest.getName());
        District foundDistrict = districtRepository.findById(id).get();
        foundDistrict.setUpdatedDate(LocalDateTime.now());

        District district = DistrictMapper.INSTANCE.districtFromUpdateDistrictRequest(updateDistrictRequest);
        district.setId(foundDistrict.getId());
        district.setCreatedDate(foundDistrict.getCreatedDate());
        district.setUpdatedDate(foundDistrict.getUpdatedDate());
        District updatedDistrict = districtRepository.save(district);

        UpdatedDistrictResponse updatedDistrictResponse = DistrictMapper.INSTANCE.updatedDistrictResponseFromDistrict(updatedDistrict);
        return updatedDistrictResponse;
    }

    @Override
    public DeletedDistrictResponse delete(String id) {
        districtBusinessRules.districtNotFound(id);
        districtBusinessRules.districtIsDeleted(id);
        District foundDistrict = districtRepository.findById(id).get();
        foundDistrict.setDeletedDate(LocalDateTime.now());
        District deletedDistrict = districtRepository.save(foundDistrict);

        DeletedDistrictResponse deletedDistrictResponse = DistrictMapper.INSTANCE.deletedDistrictResponseFromDistrict(deletedDistrict);
        return deletedDistrictResponse;
    }

    @Override
    public List<GetDistrictByCityIdResponse> getByCityId(String cityId) {
        List<District> districts = this.districtRepository.findByCityId(cityId);
        List<GetDistrictByCityIdResponse> getDistrictByCityIdResponse = districts
                .stream().map(DistrictMapper.INSTANCE::getDistrictByCityIdResponseFromDistrict).collect(Collectors.toList());
        return getDistrictByCityIdResponse;
    }
}

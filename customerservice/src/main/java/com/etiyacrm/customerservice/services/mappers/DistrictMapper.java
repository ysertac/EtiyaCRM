package com.etiyacrm.customerservice.services.mappers;


import com.etiyacrm.customerservice.entities.City;
import com.etiyacrm.customerservice.entities.District;
import com.etiyacrm.customerservice.services.dtos.requests.districtRequests.CreateDistrictRequest;
import com.etiyacrm.customerservice.services.dtos.requests.districtRequests.UpdateDistrictRequest;
import com.etiyacrm.customerservice.services.dtos.responses.CityResponses.GetCityByCountryIdResponse;
import com.etiyacrm.customerservice.services.dtos.responses.districtResponses.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DistrictMapper {
    DistrictMapper INSTANCE = Mappers.getMapper(DistrictMapper.class);
    @Mapping(source = "district.city.id", target = "cityId")
    GetAllDistrictResponse getAllDistrictResponseFromDistrict(District district);
    @Mapping(source = "district.city.id", target = "cityId")
    GetDistrictResponse getDistrictResponseFromDistrict(District district);
    @Mapping(source = "createDistrictRequest.cityId", target = "city.id")
    District districtFromCreateDistrictRequest(CreateDistrictRequest createDistrictRequest);
    @Mapping(source = "district.city.id", target = "cityId")
    CreatedDistrictResponse createdDistrictResponseFromDistrict(District district);
    @Mapping(source = "updateDistrictRequest.cityId", target = "city.id")
    District districtFromUpdateDistrictRequest(UpdateDistrictRequest updateDistrictRequest);
    @Mapping(source = "district.city.id", target = "cityId")
    UpdatedDistrictResponse updatedDistrictResponseFromDistrict(District district);
    @Mapping(source = "district.city.id", target = "cityId")
    DeletedDistrictResponse deletedDistrictResponseFromDistrict(District district);
    @Mapping(source = "district.city.id", target = "cityId")
    GetDistrictByCityIdResponse getDistrictByCityIdResponseFromDistrict(District district);
}

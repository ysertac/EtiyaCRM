package com.etiyacrm.customerservice.controllers;

import com.etiyacrm.customerservice.services.abstracts.DistrictService;
import com.etiyacrm.customerservice.services.dtos.requests.districtRequests.CreateDistrictRequest;
import com.etiyacrm.customerservice.services.dtos.requests.districtRequests.UpdateDistrictRequest;
import com.etiyacrm.customerservice.services.dtos.responses.CityResponses.GetCityByCountryIdResponse;
import com.etiyacrm.customerservice.services.dtos.responses.districtResponses.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin()
@RestController
@RequestMapping("api/v1/districts")
@AllArgsConstructor
public class DistrictsController {
    private DistrictService districtService;

    @PostMapping
    public CreatedDistrictResponse add(@Valid @RequestBody CreateDistrictRequest createDistrictRequest) {
        return districtService.add(createDistrictRequest);
    }

    @GetMapping
    public List<GetAllDistrictResponse> getAll() {
        return districtService.getAll();
    }

    @GetMapping("/{id}")
    public GetDistrictResponse getById(@PathVariable String id) {
        return districtService.getById(id);
    }

    @PutMapping("/{id}")
    public UpdatedDistrictResponse update(@Valid @RequestBody UpdateDistrictRequest updateDistrictRequest, @PathVariable String id) {
        return districtService.update(updateDistrictRequest, id);
    }

    @DeleteMapping("/{id}")
    public DeletedDistrictResponse delete(@PathVariable String id) {
        return districtService.delete(id);
    }

    @GetMapping("/cityid/{cityId}")
    public List<GetDistrictByCityIdResponse> getByCityId(@PathVariable String cityId){
        return districtService.getByCityId(cityId);
    }
}

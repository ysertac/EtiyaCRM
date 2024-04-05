package com.etiyacrm.customerservice.controllers;

import com.etiyacrm.customerservice.core.business.paging.PageInfo;
import com.etiyacrm.customerservice.core.responses.GetListResponse;
import com.etiyacrm.customerservice.services.abstracts.CityService;
import com.etiyacrm.customerservice.services.dtos.requests.cityRequests.CreateCityRequest;
import com.etiyacrm.customerservice.services.dtos.requests.cityRequests.UpdateCityRequest;
import com.etiyacrm.customerservice.services.dtos.responses.CityResponses.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("customerservice/api/v1/cities")
@AllArgsConstructor
public class CitiesController {
    private CityService cityService;

    @PostMapping
    public CreatedCityResponse add(@Valid @RequestBody CreateCityRequest createCityRequest) {
        return cityService.add(createCityRequest);
    }

    @GetMapping
    public GetListResponse<GetAllCityResponse> getAll(@RequestParam int page, @RequestParam int size) {
        return cityService.getAll(new PageInfo(page, size));
    }

    @GetMapping("/{id}")
    public GetCityResponse getById(@PathVariable long id) {
        return cityService.getById(id);
    }

    @PutMapping("/{id}")
    public UpdatedCityResponse update(@RequestBody UpdateCityRequest updateCityRequest, @PathVariable long id) {
        return cityService.update(updateCityRequest, id);
    }

    @DeleteMapping("/{id}")
    public DeletedCityResponse delete(@PathVariable long id) {
        return cityService.delete(id);
    }
}

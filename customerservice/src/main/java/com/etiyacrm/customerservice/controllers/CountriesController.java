package com.etiyacrm.customerservice.controllers;


import com.etiyacrm.customerservice.services.abstracts.CountryService;
import com.etiyacrm.customerservice.services.dtos.requests.countryRequests.CreateCountryRequest;
import com.etiyacrm.customerservice.services.dtos.requests.countryRequests.UpdateCountryRequest;
import com.etiyacrm.customerservice.services.dtos.responses.CountryResponses.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin()
@RestController
@RequestMapping("api/v1/countries")
@AllArgsConstructor
public class CountriesController {
    private CountryService countryService;

    @PostMapping
    public CreatedCountryResponse add(@Valid @RequestBody CreateCountryRequest createCountryRequest) {
        return countryService.add(createCountryRequest);
    }

    @GetMapping
    public List<GetAllCountryResponse> getAll() {
        return countryService.getAll();
    }

    @GetMapping("/{id}")
    public GetCountryResponse getById(@PathVariable String id) {
        return countryService.getById(id);
    }

    @PutMapping("/{id}")
    public UpdatedCountryResponse update(@Valid @RequestBody UpdateCountryRequest updateCountryRequest, @PathVariable String id) {
        return countryService.update(updateCountryRequest, id);
    }

    @DeleteMapping("/{id}")
    public DeletedCountryResponse delete(@PathVariable String id) {
        return countryService.delete(id);
    }
}

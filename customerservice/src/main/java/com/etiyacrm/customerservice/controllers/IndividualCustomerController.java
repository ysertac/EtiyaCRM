package com.etiyacrm.customerservice.controllers;

import com.etiyacrm.customerservice.services.abstracts.IndividualCustomerService;
import com.etiyacrm.customerservice.services.dtos.requests.individualCustomerRequests.CheckTurkishCitizenRequest;
import com.etiyacrm.customerservice.services.dtos.requests.individualCustomerRequests.CreateIndividualCustomerRequest;
import com.etiyacrm.customerservice.services.dtos.requests.individualCustomerRequests.UpdateIndividualCustomerRequest;
import com.etiyacrm.customerservice.services.dtos.responses.IndividualCustomerResponses.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin()
@RestController
@RequestMapping("api/v1/individualcustomers")
@AllArgsConstructor
public class IndividualCustomerController {
    private IndividualCustomerService individualCustomerService;

    @PostMapping
    public CreatedIndividualCustomerResponse add(@Valid @RequestBody CreateIndividualCustomerRequest createIndividualCustomerRequest) throws Exception {
        return individualCustomerService.add(createIndividualCustomerRequest);
    }

    @PostMapping("/checkmernis")
    public boolean checkIfRealPerson(@RequestBody CheckTurkishCitizenRequest checkTurkishCitizenRequest) throws Exception {
        return individualCustomerService.checkIfTurkishCitizen(checkTurkishCitizenRequest);
    }

    @GetMapping
    public List<GetAllIndividualCustomerResponse> findAll() {
        return individualCustomerService.findAll();
    }

    @GetMapping("/nationalityid")
    public boolean isIndividualCustomerExistsByNationalityId(String nationalityId) {
        return individualCustomerService.isIndividualCustomerExistsByNationalityId(nationalityId);
    }

    @GetMapping("/{id}")
    public GetIndividualCustomerResponse findById(@PathVariable String id) {
        return individualCustomerService.findById(id);
    }

    @PutMapping("/{id}")
    public UpdatedIndividualCustomerResponse update(
            @Valid @RequestBody UpdateIndividualCustomerRequest updateIndividualCustomerRequest, @PathVariable String id) throws Exception{
        return individualCustomerService.update(updateIndividualCustomerRequest, id);
    }

    @DeleteMapping("/{id}")
    public DeletedIndividualCustomerResponse delete(@PathVariable String id) {
        return individualCustomerService.delete(id);
    }
}

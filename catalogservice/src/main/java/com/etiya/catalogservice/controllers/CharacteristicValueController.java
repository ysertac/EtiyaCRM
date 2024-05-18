package com.etiya.catalogservice.controllers;

import com.etiya.catalogservice.core.business.paging.PageInfo;
import com.etiya.catalogservice.core.responses.GetListResponse;
import com.etiya.catalogservice.services.abstracts.CharacteristicValueService;
import com.etiya.catalogservice.services.dtos.requests.characteristicValueRequests.CreateCharacteristicValueRequest;
import com.etiya.catalogservice.services.dtos.requests.characteristicValueRequests.UpdateCharacteristicValueRequest;
import com.etiya.catalogservice.services.dtos.responses.characteristicValueResponses.*;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@AllArgsConstructor
@RequestMapping("api/v1/characteristic-values")
public class CharacteristicValueController {

    private CharacteristicValueService characteristicValueService;

    @PostMapping
    public CreatedCharacteristicValueResponse add(@RequestBody CreateCharacteristicValueRequest createCharacteristicValueRequest) {
        return characteristicValueService.add(createCharacteristicValueRequest);
    }

    @GetMapping()
    public GetListResponse<GetAllCharacteristicValueResponse> getAll(@RequestParam int page, @RequestParam int size) {
        return characteristicValueService.getAll(new PageInfo(page, size));
    }

    @GetMapping("/{id}")
    public GetCharacteristicValueResponse getById(@PathVariable String id) {
        return characteristicValueService.getById(id);
    }

    @PutMapping("/{id}")
    public UpdatedCharacteristicValueResponse update(@RequestBody UpdateCharacteristicValueRequest updateCharacteristicValueRequest, @PathVariable String id) {
        return characteristicValueService.update(updateCharacteristicValueRequest, id);
    }

    @DeleteMapping("/{id}")
    public DeletedCharacteristicValueResponse delete(@PathVariable String id) {
        return characteristicValueService.delete(id);
    }
}

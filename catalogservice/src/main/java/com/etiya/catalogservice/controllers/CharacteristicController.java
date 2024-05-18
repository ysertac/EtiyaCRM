package com.etiya.catalogservice.controllers;

import com.etiya.catalogservice.core.business.paging.PageInfo;
import com.etiya.catalogservice.core.responses.GetListResponse;
import com.etiya.catalogservice.services.abstracts.CharacteristicService;
import com.etiya.catalogservice.services.dtos.requests.characteristicRequests.CreateCharacteristicRequest;
import com.etiya.catalogservice.services.dtos.requests.characteristicRequests.UpdateCharacteristicRequest;
import com.etiya.catalogservice.services.dtos.responses.characteristicResponses.*;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@AllArgsConstructor
@RequestMapping("api/v1/characteristics")
public class CharacteristicController {

    private CharacteristicService characteristicService;

    @PostMapping
    public CreatedCharacteristicResponse add(@RequestBody CreateCharacteristicRequest createCharacteristicRequest) {
        return characteristicService.add(createCharacteristicRequest);
    }

    @GetMapping()
    public GetListResponse<GetAllCharacteristicResponse> getAll(@RequestParam int page, @RequestParam int size) {
        return characteristicService.getAll(new PageInfo(page, size));
    }

    @GetMapping("/{id}")
    public GetCharacteristicResponse getById(@PathVariable String id) {
        return characteristicService.getById(id);
    }

    @PutMapping("/{id}")
    public UpdatedCharacteristicResponse update(@RequestBody UpdateCharacteristicRequest updateCharacteristicRequest, @PathVariable String id) {
        return characteristicService.update(updateCharacteristicRequest, id);
    }

    @DeleteMapping("/{id}")
    public DeletedCharacteristicResponse delete(@PathVariable String id) {
        return characteristicService.delete(id);
    }
}

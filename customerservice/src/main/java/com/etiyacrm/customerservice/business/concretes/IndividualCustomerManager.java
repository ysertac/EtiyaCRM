package com.etiyacrm.customerservice.business.concretes;

import com.etiyacrm.customerservice.business.abstracts.IndividualCustomerService;
import com.etiyacrm.customerservice.business.dtos.requests.IndividualCustomerRequests.CreateIndividualCustomerRequest;
import com.etiyacrm.customerservice.business.dtos.requests.IndividualCustomerRequests.UpdateIndividualCustomerRequest;
import com.etiyacrm.customerservice.business.dtos.responses.IndividualCustomerResponses.CreatedIndividualCustomerResponse;
import com.etiyacrm.customerservice.business.dtos.responses.IndividualCustomerResponses.DeletedIndividualCustomerResponse;
import com.etiyacrm.customerservice.business.dtos.responses.IndividualCustomerResponses.GetIndividualCustomerResponse;
import com.etiyacrm.customerservice.business.dtos.responses.IndividualCustomerResponses.UpdatedIndividualCustomerResponse;
import com.etiyacrm.customerservice.core.utilities.mapping.ModelMapperService;
import com.etiyacrm.customerservice.dataAccess.abstracts.IndividualCustomerRepository;
import com.etiyacrm.customerservice.entities.Customer;
import com.etiyacrm.customerservice.entities.IndividualCustomer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class IndividualCustomerManager implements IndividualCustomerService {
    private IndividualCustomerRepository individualCustomerRepository;
    private ModelMapperService modelMapperService;

    @Override
    public CreatedIndividualCustomerResponse add(CreateIndividualCustomerRequest createIndividualCustomerRequest) {
        Customer customer = new Customer();
        customer.setEmail(createIndividualCustomerRequest.getEmail());
        customer.setCreatedDate(LocalDateTime.now());

        IndividualCustomer mappedIndividualCustomer = modelMapperService
                .forRequest().map(createIndividualCustomerRequest, IndividualCustomer.class);
        mappedIndividualCustomer.setCustomer(customer);

        IndividualCustomer createdCustomer = individualCustomerRepository.save(mappedIndividualCustomer);

        CreatedIndividualCustomerResponse createIndividualCustomerResponse =
                modelMapperService.forResponse().map(createdCustomer, CreatedIndividualCustomerResponse.class);
        return createIndividualCustomerResponse;
    }

    @Override
    public List<GetIndividualCustomerResponse> findAll() {
        List<IndividualCustomer> allIndividualCustomers = individualCustomerRepository.findAll();
        List<GetIndividualCustomerResponse> getIndividualCustomerResponses = allIndividualCustomers.stream()
                .filter(individualCustomer -> individualCustomer.getCustomer().getDeletedDate() == null)
                .map(individualCustomer ->
                modelMapperService.forResponse().map(individualCustomer, GetIndividualCustomerResponse.class)).collect(Collectors.toList());
        return getIndividualCustomerResponses;
    }

    @Override
    public GetIndividualCustomerResponse findById(long id) {
        IndividualCustomer foundIndividualCustomer = individualCustomerRepository.findById(id).get();
        GetIndividualCustomerResponse getIndividualCustomerResponse =
                modelMapperService.forResponse().map(foundIndividualCustomer, GetIndividualCustomerResponse.class);
        return getIndividualCustomerResponse;
    }

    @Override
    public UpdatedIndividualCustomerResponse update(UpdateIndividualCustomerRequest updateIndividualCustomerRequest, long id) {
        IndividualCustomer foundIndividualCustomer = individualCustomerRepository.findById(id).get();
        IndividualCustomer mappedIndividualCustomer =
                modelMapperService.forRequest().map(updateIndividualCustomerRequest, IndividualCustomer.class);
        mappedIndividualCustomer.setId(id);
        mappedIndividualCustomer.setCustomer(foundIndividualCustomer.getCustomer());
        mappedIndividualCustomer.getCustomer().setCreatedDate(foundIndividualCustomer.getCustomer().getCreatedDate());
        mappedIndividualCustomer.getCustomer().setUpdatedDate(LocalDateTime.now());

        IndividualCustomer updatedIndividualCustomer = individualCustomerRepository.save(mappedIndividualCustomer);

        UpdatedIndividualCustomerResponse updatedIndividualCustomerResponse =
                modelMapperService.forResponse().map(updatedIndividualCustomer, UpdatedIndividualCustomerResponse.class);
        return updatedIndividualCustomerResponse;
    }

    @Override
    public DeletedIndividualCustomerResponse delete(long id) {
        IndividualCustomer foundIndividualCustomer = individualCustomerRepository.findById(id).get();
        foundIndividualCustomer.getCustomer().setId(id);
        foundIndividualCustomer.getCustomer().setDeletedDate(LocalDateTime.now());

        IndividualCustomer deletedIndividualCustomer = individualCustomerRepository.save(foundIndividualCustomer);

        DeletedIndividualCustomerResponse deletedIndividualCustomerResponse =
                modelMapperService.forResponse().map(deletedIndividualCustomer, DeletedIndividualCustomerResponse.class);
        return deletedIndividualCustomerResponse;
    }
}

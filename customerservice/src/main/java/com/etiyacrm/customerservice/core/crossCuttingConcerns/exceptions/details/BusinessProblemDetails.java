package com.etiyacrm.customerservice.core.crossCuttingConcerns.exceptions.details;

public class BusinessProblemDetails extends ProblemDetails {
    public BusinessProblemDetails() {
        setType("https://etiya.com/exceptions/business");
        setTitle("Business Rule Violation");
        setStatus("400");
    }
}

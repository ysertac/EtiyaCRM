package com.etiyacrm.customerservice.core.crossCuttingConcerns.exceptions.details;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
public class ValidationProblemDetails extends ProblemDetails {
    private List<Map<String, String>> errors;

    public ValidationProblemDetails() {
        setTitle("Validation Exception");
        setType("https://etiya.com/exceptions/validation");
        setStatus("400");
        setDetail("Validation Rule Problems");
    }
}

package com.etiyacrm.customerservice.core.crossCuttingConcerns.exceptions.handlers;

import com.etiyacrm.customerservice.core.crossCuttingConcerns.exceptions.details.BusinessProblemDetails;
import com.etiyacrm.customerservice.core.crossCuttingConcerns.exceptions.details.ProblemDetails;
import com.etiyacrm.customerservice.core.crossCuttingConcerns.exceptions.details.ValidationProblemDetails;
import com.etiyacrm.customerservice.core.crossCuttingConcerns.exceptions.types.BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({BusinessException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public BusinessProblemDetails handleBusinessException(BusinessException exception) {
        BusinessProblemDetails problemDetails = new BusinessProblemDetails();
        problemDetails.setDetail(exception.getMessage());
        return problemDetails;
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ValidationProblemDetails handleValidationException(MethodArgumentNotValidException exception) {
        List<Map<String, String>> validationErrors = new ArrayList<>();

        exception.getBindingResult().getFieldErrors().forEach(fieldError -> {
            Map<String, String> validationError = new HashMap<>();
            validationError.put("field", fieldError.getField());
            validationError.put("message", fieldError.getDefaultMessage());
            validationErrors.add(validationError);
        });

        ValidationProblemDetails validationProblemDetails = new ValidationProblemDetails();
        validationProblemDetails.setErrors(validationErrors);
        return validationProblemDetails;
    }

    @ExceptionHandler({Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ProblemDetails handleException() {
        return new ProblemDetails("Unknown Error",
                "Some error occurred.", "https://etiya.com/exceptions/unknown","500");
    }
}

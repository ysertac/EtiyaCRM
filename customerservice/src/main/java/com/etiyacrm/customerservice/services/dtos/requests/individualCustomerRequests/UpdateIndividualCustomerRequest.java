package com.etiyacrm.customerservice.services.dtos.requests.individualCustomerRequests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateIndividualCustomerRequest {
    @NotNull
    @NotBlank(message = "First name can not be empty")
    @Size(max = 30, message = "First name may have minimum 3 and maximum 30 characters")
    private String firstName;

    @Size(max = 30, message = "Middle name may have maximum 30 characters")
    private String middleName;

    @NotNull
    @NotBlank(message = "Last name can not be empty")
    @Size(max = 30, message = "Last name may have minimum 3 and maximum 30 characters")
    private String lastName;

    @NotNull
    @NotBlank(message = "Gender can not be empty")
    private String gender;

    @Size(max = 30, message = "Mother name may have minimum 3 and maximum 30 characters")
    private String motherName;

    @Size(max = 30, message = "Father name may have minimum 3 and maximum 30 characters")
    private String fatherName;

    @NotNull
    @Pattern(regexp = "^[1-9]{1}[0-9]{9}[02468]{1}$", message = "Invalid National ID number ")
    private String nationalityId;

    @NotNull
    private LocalDate birthDate;
}

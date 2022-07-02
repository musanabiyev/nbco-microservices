package com.company.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CreateCustomerRequestDTO {


    private String name;
    private String surname;
    private String phoneNumber;
    private String address;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate birthDate;

    private Long userId;
    private Long LoanId;
}

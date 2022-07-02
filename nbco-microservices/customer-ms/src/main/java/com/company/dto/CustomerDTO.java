package com.company.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO {

    private Long id;
    private String name;
    private String surname;
    private String phoneNumber;
    private String address;
    private LocalDate dateOfBirth;
    private Long userId;
    private Long LoanId;
    private LocalDateTime creationDate;
    private LocalDateTime updatedAt;
}

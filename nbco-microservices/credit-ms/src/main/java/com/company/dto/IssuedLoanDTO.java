package com.company.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IssuedLoanDTO {

    private Long id;
    private LocalDate startDateOfLoan;
    private LocalDate endDateOfLoan;
    private BigDecimal durationPerMonth;
    private BigDecimal amount;
    private Double percentage;

}

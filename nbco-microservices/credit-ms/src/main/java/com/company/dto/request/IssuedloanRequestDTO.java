package com.company.dto.request;

import com.company.model.IssuedloanData;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IssuedloanRequestDTO {

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate startDateOfLoan;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate endDateOfLoan;

    private int durationPerMonth;

    private BigDecimal amount;
    private Double percentage;
    private Long customerDataId;

    private List<IssuedloanData> issuedloanDataList;
}

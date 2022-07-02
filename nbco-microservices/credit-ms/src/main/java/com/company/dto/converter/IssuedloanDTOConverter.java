package com.company.dto.converter;

import com.company.dto.IssuedLoanDTO;
import com.company.model.IssuedLoan;
import lombok.extern.apachecommons.CommonsLog;
import org.hibernate.validator.constraints.CodePointLength;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class IssuedloanDTOConverter {

    public IssuedLoanDTO convert(IssuedLoan from){
        return new IssuedLoanDTO(
                from.getId(),from.getStartDateOfLoan(),from.getEndDateOfLoan(),
                from.getDurationPerMonth(),from.getAmount(),from.getPercentage()
        );
    }
    private Long id;
    private LocalDate startDateOfLoan;
    private LocalDate endDateOfLoan;
    private BigDecimal durationPerMonth;
    private BigDecimal amount;
    private Double percentage;




    public List<IssuedLoanDTO> convert(List<IssuedLoan> fromList){
        return fromList.stream().map(from ->
                new IssuedLoanDTO(from.getId(),from.getStartDateOfLoan(),from.getEndDateOfLoan(),
                from.getDurationPerMonth(),from.getAmount(),from.getPercentage()))
                .collect(Collectors.toList());
    }
}

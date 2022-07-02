package com.company.service;

import com.company.dto.IssuedLoanDTO;
import com.company.dto.IssuedloanDataDTO;
import com.company.dto.converter.IssuedloanDTOConverter;
import com.company.dto.request.IssuedloanRequestDTO;
import com.company.model.IssuedLoan;
import com.company.model.IssuedloanData;
import com.company.repository.IssuedLoanRepository;
import io.swagger.models.auth.In;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
@Transactional
public class IssuedLoanService {

    private final IssuedLoanRepository issuedLoanRepository;
    private final IssuedloanDTOConverter issuedloanDTOConverter;

    public IssuedLoanService(IssuedLoanRepository issuedLoanRepository,
                             IssuedloanDTOConverter issuedloanDTOConverter) {
        this.issuedLoanRepository = issuedLoanRepository;
        this.issuedloanDTOConverter = issuedloanDTOConverter;
    }


    public IssuedLoanDTO getIssuedloan(Long id) {
        return issuedloanDTOConverter.convert(issuedLoanRepository.findIssuedLoanById(id));

    }

    public IssuedLoanDTO addIssuedLoan(IssuedloanRequestDTO issuedloanRequestDTO) {
        //check customer id
        IssuedLoan issuedLoan = IssuedLoan.builder()
                .startDateOfLoan(issuedloanRequestDTO.getStartDateOfLoan())
                .endDateOfLoan(issuedloanRequestDTO.getEndDateOfLoan())
                .durationPerMonth(issuedloanRequestDTO.getDurationPerMonth())
                .amount(issuedloanRequestDTO.getAmount())
                .percentage(issuedloanRequestDTO.getPercentage())
                .customerDataId(issuedloanRequestDTO.getCustomerDataId()).build();

        IssuedLoan saveissuedLoan = issuedLoanRepository.save(issuedLoan);

        IssuedloanData issuedloanData = saveIssuedloanData(saveissuedLoan);
        saveissuedLoan.setIssuedloanData(issuedloanData);

        return issuedloanDTOConverter.convert(saveissuedLoan);
    }

    private IssuedloanData saveIssuedloanData(IssuedLoan issuedLoan) {

    }


}


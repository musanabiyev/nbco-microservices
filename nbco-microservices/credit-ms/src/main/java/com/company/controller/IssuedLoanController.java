package com.company.controller;


import com.company.dto.IssuedLoanDTO;
import com.company.dto.request.IssuedloanRequestDTO;
import com.company.service.IssuedLoanService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("v1/loan")
public class IssuedLoanController {

    private final IssuedLoanService issuedLoanService;


    @GetMapping(value = "/get/{id}")
    public ResponseEntity<IssuedLoanDTO> getIssuedloan(@PathVariable("id") Long id) {

        return ResponseEntity.ok(issuedLoanService.getIssuedloan(id));
    }


    @PostMapping(value = "/add")
    public ResponseEntity<?> addIssuedLoan(
            @Valid @RequestBody IssuedloanRequestDTO issuedloanRequestDTO) {
        return ResponseEntity.ok(issuedLoanService.addIssuedLoan(issuedloanRequestDTO));
    }

}

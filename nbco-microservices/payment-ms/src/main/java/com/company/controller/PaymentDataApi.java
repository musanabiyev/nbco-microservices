package com.company.controller;

import com.company.dto.CreatePaymenDatatRequestDTO;
import com.company.dto.PaymentDataDTO;
import com.company.service.PaymentDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/payment")
@RequiredArgsConstructor
public class PaymentDataApi {

    private final PaymentDataService paymentDataService;

    @GetMapping(value = "/getcreditid{id}")
    public ResponseEntity<List<PaymentDataDTO>> getPayment(@PathVariable("id") Long id) {
        return ResponseEntity.ok(paymentDataService.getPaymentDataByCreditId(id));
    }

    @PostMapping("/add")
    public PaymentDataDTO addPayment(@RequestBody CreatePaymenDatatRequestDTO requestDTO) {
        return paymentDataService.save(requestDTO);
    }
}

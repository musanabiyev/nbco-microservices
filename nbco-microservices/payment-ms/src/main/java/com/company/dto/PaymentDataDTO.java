package com.company.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDataDTO {

    private Long Id;
    private Double amount;
    private LocalDateTime dateTime;
    private Long creditId;
}

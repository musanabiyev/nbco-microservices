package com.company.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "payment_data")
public class PaymentData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long Id;

    @Column(name = "amount")
    private Double amount;

    @Column(name = "date")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDateTime date;

    @Column(name = "credit_id")
    private Long creditId;
}
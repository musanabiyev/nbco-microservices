package com.company.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "issuedloan")
public class IssuedLoan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "start_date_of_loan")
    private LocalDate startDateOfLoan;

    @Column(name = "end_date_of_loan")
    private LocalDate endDateOfLoan;

    @Column(name = "duration_per_month")
    private int durationPerMonth;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "percentage")
    private Double percentage;

    @Column(name = "customer_data_id")
    private Long customerDataId;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "issuedloanId")
    private IssuedloanData issuedloanData;

}
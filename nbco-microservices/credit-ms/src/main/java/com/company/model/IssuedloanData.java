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
@Table(name = "issuedloan_data")
public class IssuedloanData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;

    @Column(name = "amount_of_payment")
    private Double amountOfPayment;

    @Column(name = "interest_charges")
    private BigDecimal interestCharges;

    @Column(name = "main_debt")
    private BigDecimal mainDebt;

    @Column(name = "payment_date")
    @Temporal(TemporalType.DATE)
    private LocalDate paymentDate;

    @Column(name = "payment_no")
    private Long paymentNo;

    @Column(name = "remaining_debt")
    private BigDecimal remainingDebt;

    @JoinColumn(name = "issuedloan_id", referencedColumnName = "id")
    @OneToOne(optional = false)
    private IssuedLoan issuedloanId;

}

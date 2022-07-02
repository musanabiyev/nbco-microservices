package com.company.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = Customer.TABLE_NAME)
public class Customer implements Serializable {

    public static final String TABLE_NAME = "customer";
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "address")
    private String address;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "loan_id")
    private Long LoanId;

    @Column(name = "creation_date", updatable = false)
    private LocalDateTime creationDate;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

}
package com.company.repository;

import com.company.model.IssuedLoan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IssuedLoanRepository extends JpaRepository<IssuedLoan, Long> {

    IssuedLoan findIssuedLoanById(Long id);

}

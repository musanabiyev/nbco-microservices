package com.company.dao;

import com.company.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Customer findCustomerByUserId(Long userId);

    Customer findCustomerById(Long id);

    Customer findCustomerByLoanId(Long id);
}

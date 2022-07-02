package com.company.dao;

import com.company.model.PaymentData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentDataRepository extends JpaRepository<PaymentData, Long> {


    List<PaymentData> findAllByCreditId(Long creditId);
}

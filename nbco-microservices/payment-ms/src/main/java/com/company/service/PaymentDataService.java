package com.company.service;

import com.company.dao.PaymentDataRepository;
import com.company.dto.CreatePaymenDatatRequestDTO;
import com.company.dto.PaymentDataDTO;
import com.company.model.PaymentData;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;


@Service
@Transactional
public class PaymentDataService {

    private final PaymentDataRepository paymentDataRepository;
    private final ModelMapper modelMapper;

    public PaymentDataService(PaymentDataRepository paymentDataRepository, ModelMapper modelMapper) {
        this.paymentDataRepository = paymentDataRepository;
        this.modelMapper = modelMapper;
    }

    public PaymentDataDTO save(CreatePaymenDatatRequestDTO requestDTO) {
        //need to check the credit id
        PaymentData paymentData = PaymentData.builder()
                .amount(requestDTO.getAmount())
                .creditId(requestDTO.getCreditId())
                .date(LocalDateTime.now())
                .build();

        return modelMapper.map(paymentDataRepository.save(paymentData), PaymentDataDTO.class);
    }

    public List<PaymentDataDTO> getPaymentDataByCreditId(Long creditId) {
        List<PaymentData> paymentDataList = paymentDataRepository.findAllByCreditId(creditId);

        List<PaymentDataDTO> paymentDataDTOS = paymentDataList.stream()
                .map(paymentData -> modelMapper.map(paymentData, PaymentDataDTO.class))
                .collect(Collectors.toList());

        return paymentDataDTOS;
    }
}

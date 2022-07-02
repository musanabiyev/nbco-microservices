package com.company.service;

import com.company.dao.CustomerRepository;
import com.company.dto.CustomerDTO;
import com.company.dto.request.CreateCustomerRequestDTO;
import com.company.entity.Customer;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;


    public List<CustomerDTO> getAllCustomer() {
        List<Customer> customerList = customerRepository.findAll();

        List<CustomerDTO> customerDTOList = customerList.stream()
                .map(customer -> modelMapper.map(customer, CustomerDTO.class))
                .collect(Collectors.toList());

        return customerDTOList;
    }

    public CustomerDTO createCustomer(CreateCustomerRequestDTO requestDTO) {
        Customer customer = Customer.builder()
                .name(requestDTO.getName()).surname(requestDTO.getSurname()).address(requestDTO.getAddress())
                .phoneNumber(requestDTO.getPhoneNumber()).dateOfBirth(requestDTO.getBirthDate()).build();

        return modelMapper.map(customerRepository.save(customer), CustomerDTO.class);
    }

    public CustomerDTO getCustomerById(Long id) {
        return modelMapper.map(customerRepository.findCustomerById(id), CustomerDTO.class);
    }

    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
}

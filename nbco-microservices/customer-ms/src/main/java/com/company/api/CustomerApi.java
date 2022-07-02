package com.company.api;

import com.company.dto.CustomerDTO;
import com.company.dto.response.BaseResponseDTO;
import com.company.dto.request.CreateCustomerRequestDTO;
import com.company.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping(CustomerApi.ENDPOINT)
public class CustomerApi {

    public static final String ENDPOINT = "/v1/customers";

    private static final Logger logger = Logger.getLogger("api.CustomerApi");

    private final CustomerService customerService;


    public CustomerApi(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping(value = "/{id}")
    public BaseResponseDTO<CustomerDTO> getCustomerData(@PathVariable("id") Long id){
        return BaseResponseDTO.success(
                customerService.getCustomerById(id), "successfully");
    }

    @GetMapping(value = "/all")
    public BaseResponseDTO<List<CustomerDTO>> getAllCustomer(@PathVariable("id") Long id){
        return BaseResponseDTO.success(
                customerService.getAllCustomer(), "successfully");
    }


    @PostMapping(value = "/add")
    public BaseResponseDTO<CustomerDTO> addCustomerData(
            @Valid @RequestBody CreateCustomerRequestDTO customerRequestDTO) {

        return BaseResponseDTO.success(
                customerService.createCustomer(customerRequestDTO), "successfully");

    }

}


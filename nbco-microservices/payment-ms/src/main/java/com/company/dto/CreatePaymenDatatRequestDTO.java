package com.company.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreatePaymenDatatRequestDTO {

    @NotNull
    private Double amount;

    @NotNull
    private Long creditId;

}

package com.company.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateUserRequestDTO {

    private String firstname;
    private String lastname;
    private String username;
    private String email;
    private String phone;
}

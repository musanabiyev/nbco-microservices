package com.company.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserRequestDTO {

    private String firstname;
    private String lastname;
    private String username;
    private String email;
    private String phone;
    private String password;

//    @JsonFormat(pattern="dd-MM-yyyy")
//    private LocalDate birthDate;

}

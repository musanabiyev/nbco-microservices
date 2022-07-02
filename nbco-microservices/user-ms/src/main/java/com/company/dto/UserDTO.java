package com.company.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private Long id;
    private String firstname;
    private String lastname;
    private String username;
    private String email;
    private String phone;
    private LocalDateTime creationDate;
    private LocalDateTime updatedAt;


}

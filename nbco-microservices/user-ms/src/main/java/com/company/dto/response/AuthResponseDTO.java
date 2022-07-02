package com.company.dto.response;

import com.company.domain.RefreshToken;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthResponseDTO {

    private JWTResponseDTO accessToken;

    private RefreshTokenDTO refreshTokenDTO;

    private ApiMessage status;

}

package com.company.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseResponseDTO<T> {

    @JsonProperty("success")
    private Boolean isSuccess;

    @JsonProperty("payload")
    private T payload;

    @JsonProperty("message")
    private String message;

}

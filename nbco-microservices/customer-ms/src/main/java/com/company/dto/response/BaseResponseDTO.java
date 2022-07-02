package com.company.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


@Data
public class BaseResponseDTO<T> {

    @JsonProperty("success")
    private Boolean isSuccess;

    @JsonProperty("payload")
    private T payload;

    @JsonProperty("message")
    private String message;


    public BaseResponseDTO(Boolean isSuccess, T payload, String message) {
        this.isSuccess = isSuccess;
        this.payload = payload;
        this.message = message;
    }

    public BaseResponseDTO() {

    }


    public static BaseResponseDTO success(Object obj, String message) {
        return new BaseResponseDTO(true, obj, message);
    }

    public static BaseResponseDTO<?> fail(Object obj, String message) {
        return new BaseResponseDTO(false, obj, message);
    }


}

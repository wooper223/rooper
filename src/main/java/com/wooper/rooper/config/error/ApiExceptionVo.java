package com.wooper.rooper.config.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public class ApiExceptionVo {
    private HttpStatus status;
    private String errorCode;
    private String errorMessage;
}

package com.wooper.rooper.config.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public class ApiException extends RuntimeException{
    private ErrorCode error;

    public ApiException(ErrorCode e) {
        super(e.getErrorMessage());
        this.error = e;
    }
}

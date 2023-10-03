package com.wooper.rooper.config.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public class ApiException extends RuntimeException{
    private String url;
    private ErrorCode error;

    public ApiException(String url, ErrorCode e) {
        super(e.getErrorMessage());
        this.url = url;
        this.error = e;
    }
}

package com.wooper.rooper.config.error;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class ApiResult {
    private String status;
    private String url;
    private String message;
    private ApiExceptionVo exception;

    public ApiResult(String status, String url, String message){
        this.status = status;
        this.url = url;
        this.message = message;
    }

}

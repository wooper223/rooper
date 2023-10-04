package com.wooper.rooper.config.error;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionAdvice {
    @ExceptionHandler({ApiException.class})
    public ResponseEntity<ApiResult> exceptionHandler(HttpServletRequest request, ApiException e){
        ApiExceptionVo apiExceptionVo = new ApiExceptionVo(e.getError().getStatus(), e.getError().getCode(), e.getError().getErrorMessage());
        ApiResult apiResult = new ApiResult("Fail", request.getRequestURI(), "", apiExceptionVo);
        return new ResponseEntity<ApiResult>(apiResult, null, e.getError().getStatus());
    }
}

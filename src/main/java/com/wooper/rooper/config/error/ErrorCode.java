package com.wooper.rooper.config.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    DUPLICATE_LOGIN_ID(HttpStatus.UNAUTHORIZED, "E0001", "이미 존재하는 아이디입니다"),
    ACCOUNT_NOT_FOUND(HttpStatus.UNAUTHORIZED, "E0002", "존재하지 않는 아이디입니다"),
    WRONG_PASSWORD(HttpStatus.UNAUTHORIZED, "E0003", "잘못된 패스워드입니다"),
    ALREADY_LOGGED_IN(HttpStatus.UNAUTHORIZED, "E0004", "이미 로그인되어 있습니다"),
    SESSION_EXPIRED(HttpStatus.UNAUTHORIZED, "E0005", "세션이 만료되었습니다");

    private HttpStatus status;
    private String code;
    private String errorMessage;
}

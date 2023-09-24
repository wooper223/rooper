package com.wooper.rooper.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Getter
public class LoginVo {
    private String userId;

    private String password;
}
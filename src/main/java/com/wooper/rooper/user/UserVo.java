package com.wooper.rooper.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Getter
public class UserVo {
    private String userId;

    private String password;

    private String telNo;

    private String email;
}

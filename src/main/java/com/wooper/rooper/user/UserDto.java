package com.wooper.rooper.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Date;

@RequiredArgsConstructor
@Getter
@Setter
public class UserDto {
    private long userNo;

    private String userId;

    private String password;

    private String telNo;

    private String email;

    private Date sbscDate;

    private Date trmnDate;
}

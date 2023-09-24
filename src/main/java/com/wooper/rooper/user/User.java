package com.wooper.rooper.user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Entity(name="user")
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@SequenceGenerator(
        name = "USER_SEQ_GENERATOR",
        sequenceName = "USER_SEQ",
        initialValue = 0,
        allocationSize = 1
)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_SEQ_GENERATOR")
    @Column(name ="user_no")
    private long userNo;

    @Column(name = "user_id")
    @NonNull
    private String userId;

    @NonNull
    private String password;

    @Column(name = "tel_no")
    @NonNull
    private String telNo;

    @NonNull
    private String email;

    @Column(name = "sbsc_date")
    @NonNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime sbscDate;

    @Column(name = "trmn_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime trmnDate;

    @Override
    public String toString(){
        return this.getUserId() + '|' + this.getPassword() + '|' + this.getSbscDate();
    }
}


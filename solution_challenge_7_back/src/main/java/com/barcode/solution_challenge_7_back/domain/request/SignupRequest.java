package com.barcode.solution_challenge_7_back.domain.request;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@NoArgsConstructor
public final class SignupRequest { // 회원가입 요청

    private String id;

    private String password;

    private String nickname;

    private String date;
}
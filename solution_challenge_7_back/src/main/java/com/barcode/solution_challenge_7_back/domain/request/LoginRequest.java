package com.barcode.solution_challenge_7_back.domain.request;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public final class LoginRequest { // 로그인 요정
    private String id;
    private String password;
}
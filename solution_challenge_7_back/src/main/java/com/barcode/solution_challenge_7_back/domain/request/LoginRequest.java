package com.barcode.solution_challenge_7_back.domain.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public final class LoginRequest { // 로그인 요정
    private String id;
    private String password;
}
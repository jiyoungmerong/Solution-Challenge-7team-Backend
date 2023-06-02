package com.barcode.solution_challenge_7_back.exception.status;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum SuccessStatus {

    SIGNUP_SUCCESS(HttpStatus.CREATED, "회원가입 성공!"),
    ;

    private final HttpStatus httpStatus;
    private final String message;
}
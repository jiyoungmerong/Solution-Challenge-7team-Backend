package com.barcode.solution_challenge_7_back.status;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum SuccessStatus {
    SIGNUP_SUCCESS(HttpStatus.CREATED, "회원가입이 완료되었습니다."),

    CREATE_ID_SUCCESS(HttpStatus.OK, "사용 가능한 아이디입니다."),

    CREATE_NICKNAME_SUCCESS(HttpStatus.OK, "사용 가능한 닉네임입니다."),


    LOGIN_SUCCESS(HttpStatus.OK, "로그인 성공!"),

    BRING_RECYCLE_METHOD_SUCCESS(HttpStatus.OK, "분리수거 방법 가져오기 성공!"),

    CERTIFICATION_SUCCESS(HttpStatus.OK, "유저 인증 성공"),

    BRING_DATE_SUCCESS(HttpStatus.OK, "사용자 지정 요일 가져오기 성공"),

    BRING_BARCODE_DATE_SUCCESS(HttpStatus.OK, "바코드 가져오기 성공"),
    ;

    private final HttpStatus httpStatus;
    private final String message;
}
package com.barcode.solution_challenge_7_back.status;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum ErrorStatus {

    /*
    BAD_REQUEST
     */
    VALIDATION_EXCEPTION(HttpStatus.BAD_REQUEST, "잘못된 요청입니다."),
    NOT_LOGIN_STATUS(HttpStatus.BAD_REQUEST, "로그인 되어있지 않습니다."),
    BARCODE_NOT_FOUND(HttpStatus.BAD_REQUEST, "바코드 번호를 찾을 수 없습니다."),
    VALIDATION_REQUEST_MISSING_EXCEPTION(HttpStatus.BAD_REQUEST, "요청값이 입력되지 않았습니다."),
    USER_CERTIFICATION_FAILED(HttpStatus.UNAUTHORIZED, "해당 아이디나 비밀번호를 가진 유저가 존재하지 않습니다."),
    USER_NOT_JOIN(HttpStatus.FORBIDDEN, "해당 사용자가 존재하지 않습니다."),




    /*
    CONFLICT
     */
    CONFLICT_ID_EXCEPTION(HttpStatus.CONFLICT, "이미 등록된 id입니다."),
    CONFLICT_NICKNAME_EXCEPTION(HttpStatus.CONFLICT, "이미 등록된 닉네임입니다."),

    /*
    SERVER_ERROR
     */
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "예상치 못한 서버 에러가 발생했습니다."),
    BAD_GATEWAY_EXCEPTION(HttpStatus.BAD_GATEWAY, "일시적인 에러가 발생하였습니다.\n잠시 후 다시 시도해주세요!"),
    SERVICE_UNAVAILABLE_EXCEPTION(HttpStatus.SERVICE_UNAVAILABLE, "현재 점검 중입니다.\n잠시 후 다시 시도해주세요!"),
    ;

    private final HttpStatus httpStatus;
    private final String message;
}
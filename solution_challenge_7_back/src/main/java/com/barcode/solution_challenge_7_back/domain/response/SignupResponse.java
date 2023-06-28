package com.barcode.solution_challenge_7_back.domain.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class SignupResponse {
    private String userId;
    private String nickname;
    private String date;

    public static SignupResponse from(String userId, String nickname, String date) {
        return new SignupResponse(userId, nickname, date);
    }
}
package com.barcode.solution_challenge_7_back.domain.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class LoginResponse {
    private String id;

    public static LoginResponse of(String id){
        return new LoginResponse(id);
    }
}

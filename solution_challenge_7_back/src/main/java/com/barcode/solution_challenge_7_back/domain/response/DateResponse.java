package com.barcode.solution_challenge_7_back.domain.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class DateResponse {
    private String date;

    public static DateResponse of(String date){

        return new DateResponse(date);
    }

}

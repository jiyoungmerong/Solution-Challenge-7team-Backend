package com.barcode.solution_challenge_7_back.domain.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class BarcodeNumberResponse {
    private String goods_name; // 상품 이름
    private String how; // 분리수거 총 방법
    private String method; // 분리수거 종류

    public static BarcodeNumberResponse from(String goods_name, String how, String method){
        return new BarcodeNumberResponse(goods_name, how, method);
    }
}

package com.barcode.solution_challenge_7_back.domain.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BarcodeDto {
    private String goods_name; // 상품 이름
    private String how; // 분리수거 총 방법
    private String method; // 분리수거 종류

    public BarcodeDto(String goods_name, String how, String method) {
        this.goods_name = goods_name;
        this.how = how;
        this.method = method;
    }
}
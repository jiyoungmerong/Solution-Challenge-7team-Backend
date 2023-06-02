package com.barcode.solution_challenge_7_back.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="BarCode")
public class BarCode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "barcode_id")
    private int id; // 인덱스

    @Column(name = "barcode_number")
    private String barcodeNumber; // 바코드 번호

    @Column(nullable = false, length = 20)
    private String goods_name; // 상품 이름

    @Column(nullable = false, length = 200)
    private String how; // 분리수거 총 방법

    @Column(nullable = false, length = 50)
    private String method; // 분리수거 분류
}
package com.barcode.solution_challenge_7_back.exception;

public class BarcodeNotFoundException extends RuntimeException{
    public BarcodeNotFoundException(String barcodeNumber) {
        super("상품 정보를 찾을 수 없습니다. 바코드 번호: " + barcodeNumber);
    }
}

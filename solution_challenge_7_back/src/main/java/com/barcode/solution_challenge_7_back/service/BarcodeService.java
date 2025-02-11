package com.barcode.solution_challenge_7_back.service;

import com.barcode.solution_challenge_7_back.domain.BarCode;
import com.barcode.solution_challenge_7_back.domain.response.BarcodeNumberResponse;
import com.barcode.solution_challenge_7_back.repository.BarcodeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class BarcodeService {
    private final BarcodeRepository barcodeRepository;

    public BarcodeNumberResponse getProductInfoByBarcode(String barcodeNumber){
        BarCode barCode = barcodeRepository.findByBarcodeNumber(barcodeNumber)
                .orElse(null);

        return BarcodeNumberResponse.from(barCode.getGoods_name(), barCode.getHow(), barCode.getMethod());
    }
}
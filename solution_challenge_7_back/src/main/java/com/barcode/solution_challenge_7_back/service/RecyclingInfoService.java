package com.barcode.solution_challenge_7_back.service;

import com.barcode.solution_challenge_7_back.domain.RecyclingInfo;
import com.barcode.solution_challenge_7_back.repository.RecyclingInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RecyclingInfoService {
    private final RecyclingInfoRepository recyclingInfoRepository;

    public String getRecyclingInfoByMaterial(String material) {
        Optional<RecyclingInfo> optionalInfo = recyclingInfoRepository.findByMaterial(material);
        return optionalInfo.map(RecyclingInfo::getHow).orElse(null);
    }
}

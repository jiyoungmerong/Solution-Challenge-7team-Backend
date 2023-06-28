package com.barcode.solution_challenge_7_back.repository;


import com.barcode.solution_challenge_7_back.domain.RecyclingInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RecyclingInfoRepository extends JpaRepository<RecyclingInfo, Long> {
    Optional<RecyclingInfo> findByMaterial(String material);
}

package com.jiyoung.hakerton.service;

import com.jiyoung.hakerton.domain.Costume;
import com.jiyoung.hakerton.repository.CostumeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class CostumeService {
    private final CostumeRepository costumeRepository;

    public List<Long> getCostumeId() {

        List<Costume> costumes = costumeRepository.findAll();

        List<Long> id = new ArrayList<>();
        for (Costume costume : costumes) {
            id.add(costume.getId());
        }

        return id;
    }


    public Optional<Costume> getCostumeDetails(Long costumeId) {
        return costumeRepository.findById(costumeId);

    }
}
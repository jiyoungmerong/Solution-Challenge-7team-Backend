package com.jiyoung.hakerton.service;

import com.jiyoung.hakerton.domain.Flag;
import com.jiyoung.hakerton.repository.FlagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class FlagService {
    private final FlagRepository flagRepository;

    public List<Long> getFlagId() {

        List<Flag> flags = flagRepository.findAll();

        List<Long> availableIds = new ArrayList<>();
        for (Flag flag : flags) {
            availableIds.add(flag.getId());
        }

        return availableIds;
    }


    public Optional<Flag> getFlagDetails(Long flagId) {
        return flagRepository.findById(flagId);
    }


}

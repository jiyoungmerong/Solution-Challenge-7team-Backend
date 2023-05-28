package com.jiyoung.hakerton.controller;

import com.jiyoung.hakerton.domain.Flag;
import com.jiyoung.hakerton.domain.dto.FlagDTO;
import com.jiyoung.hakerton.repository.FlagRepository;
import com.jiyoung.hakerton.service.FlagService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequiredArgsConstructor
public class FlagController {
    private Set<Long> flagId = new HashSet<>();

    private final FlagService flagService;
    private final FlagRepository flagRepository;

    @GetMapping("/flag")
    public ResponseEntity<FlagDTO> getRandomFlag() { // 랜덤 국기 이미지
        List<Long> id = new ArrayList<>(flagService.getFlagId());

        Collections.shuffle(id); // 리스트 섞기
        Long randomId = id.get(0); // 첫번째요소 출력
        flagId.add(randomId); // 사용한 ID 목록에 추가

        if (id.isEmpty()) {
            return ResponseEntity.notFound().build(); // 10번 다 출력하면 404 응답 반환
        }

        Optional<Flag> flag = flagService.getFlagDetails(randomId);

        if (flag.isPresent()) {
            FlagDTO flagDTO = new FlagDTO(flag);
            return ResponseEntity.ok(flagDTO);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }


    @GetMapping("/flag/hint/{id}") // 힌트 가져오기
    public ResponseEntity<String> getHint(@PathVariable("id") Long id) {
        Optional<Flag> optionalHint = flagRepository.findById(id);
        if (optionalHint.isPresent()) {
            Flag flag = optionalHint.get();
            String hint = flag.getHint();
            return ResponseEntity.ok(hint);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/answer/flag/{id}") // 정답 가져오기
    public ResponseEntity<String> getAnswer(@PathVariable("id") Long id) {
        Optional<Flag> optionalAnswer = flagRepository.findById(id);
        if (optionalAnswer.isPresent()) {
            Flag flag = optionalAnswer.get();
            String answer = flag.getAnswer();
            return ResponseEntity.ok(answer);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/info/flag/{id}") // 설명 가져오기
    public ResponseEntity<String> getInfo(@PathVariable("id") Long id) {
        Optional<Flag> optionalInfo = flagRepository.findById(id);
        if (optionalInfo.isPresent()) {
            Flag flag = optionalInfo.get();
            String info = flag.getInfo();
            return ResponseEntity.ok(info);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
}


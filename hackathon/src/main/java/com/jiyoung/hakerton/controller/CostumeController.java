package com.jiyoung.hakerton.controller;

import com.jiyoung.hakerton.domain.Costume;
import com.jiyoung.hakerton.domain.dto.CostumeDTO;
import com.jiyoung.hakerton.repository.CostumeRepository;
import com.jiyoung.hakerton.service.CostumeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequiredArgsConstructor
public class CostumeController {
    private Set<Long> costumeId = new HashSet<>(); // 중복 제거하는 set함수

    private final CostumeService costumeService;
    private final CostumeRepository costumeRepository;

    @GetMapping("/costume")
    public ResponseEntity<CostumeDTO> getRandomCostume() {
        List<Long> id = new ArrayList<>(costumeService.getCostumeId());

        Collections.shuffle(id); // 리스트 섞기

        Long randomId = id.get(0); // 첫번째 요소 출력

        costumeId.add(randomId); // 사용한 id를 set 목록에 추가

        if (id.isEmpty()) {
            return ResponseEntity.notFound().build(); // 10번 다 출력하면 404 응답 반환
        }

        Optional<Costume> costume = costumeService.getCostumeDetails(randomId);

        if (costume.isPresent()) {
            CostumeDTO costumeDTO = new CostumeDTO(costume);
            return ResponseEntity.ok(costumeDTO);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/costume/hint/{id}") // 힌트 가져오기
    public ResponseEntity<String> getHint(@PathVariable("id") Long id) {
        Optional<Costume> optionalHint = costumeRepository.findById(id);
        if (optionalHint.isPresent()) {
            Costume costume = optionalHint.get();
            String hint = costume.getHint();
            return ResponseEntity.ok(hint);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/answer/costume/{id}") // 정답 가져오기
    public ResponseEntity<String> getAnswer(@PathVariable("id") Long id) {
        Optional<Costume> optionalAnswer = costumeRepository.findById(id);
        if (optionalAnswer.isPresent()) {
            Costume costume = optionalAnswer.get();
            String answer = costume.getAnswer();
            return ResponseEntity.ok(answer);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/info/costume/{id}") // 설명 가져오기
    public ResponseEntity<String> getInfo(@PathVariable("id") Long id) {
        Optional<Costume> optionalInfo = costumeRepository.findById(id);
        if (optionalInfo.isPresent()) {
            Costume costume = optionalInfo.get();
            String info = costume.getInfo();
            return ResponseEntity.ok(info);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
}


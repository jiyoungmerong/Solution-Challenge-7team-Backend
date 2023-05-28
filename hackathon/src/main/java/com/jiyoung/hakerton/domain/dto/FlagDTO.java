package com.jiyoung.hakerton.domain.dto;

import com.jiyoung.hakerton.domain.Choice;
import com.jiyoung.hakerton.domain.Flag;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.*;
@Getter
@Setter
@NoArgsConstructor
public class FlagDTO {
    private Long id;
    private String url; // 국기 url
    private String question; // 국기_질문
    private Map<String, String> choices; // 객관식 선택지

    public FlagDTO(Optional<Flag> flag) {
        if (flag.isPresent()) {
            Flag flagEntity = flag.get();
            this.id = flagEntity.getId();
            this.url = flagEntity.getUrl();
            this.question = flagEntity.getQuestion();
            this.choices = new LinkedHashMap<>();

            Choice choice = flagEntity.getChoice();
            if (choice != null) {
                this.choices.put("one", choice.getOne());
                this.choices.put("two", choice.getTwo());
                this.choices.put("three", choice.getThree());
                this.choices.put("four", choice.getFour());
            }
        }
    }
}

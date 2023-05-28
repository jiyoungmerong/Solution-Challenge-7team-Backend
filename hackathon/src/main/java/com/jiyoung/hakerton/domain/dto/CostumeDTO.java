package com.jiyoung.hakerton.domain.dto;

import com.jiyoung.hakerton.domain.Choice;
import com.jiyoung.hakerton.domain.Costume;
import com.jiyoung.hakerton.domain.Flag;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

@Getter
@Setter
@NoArgsConstructor
public class CostumeDTO {

    private Long id;

    private String url; // 의상_url

    private String question; // 의상_질문


    private Map<String, String> choices; // 객관식 선택지

    public CostumeDTO(Optional<Costume> costume){
        if (costume.isPresent()) {
            Costume costumeEntity = costume.get();
            this.id = costumeEntity.getId();
            this.url = costumeEntity.getUrl();
            this.question = costumeEntity.getQuestion();
            this.choices = new LinkedHashMap<>();

            Choice choice = costumeEntity.getChoice();
            if (choice != null) {
                this.choices.put("one", choice.getOne());
                this.choices.put("two", choice.getTwo());
                this.choices.put("three", choice.getThree());
                this.choices.put("four", choice.getFour());
            }
        }
    }
}



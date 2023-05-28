package com.jiyoung.hakerton.domain.dto;

import com.jiyoung.hakerton.domain.Choice;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ChoiseDTO {
    private String one; // 객관식 1

    private String two; // 객관식 2

    private String three; // 객관식 3

    private String four; // 객관식 4

    public ChoiseDTO(Choice choice) {
        this.one = choice.getOne();
        this.two = choice.getTwo();
        this.three = choice.getThree();
        this.four = choice.getFour();
    }
}

package com.jiyoung.hakerton.domain.response;

import com.jiyoung.hakerton.domain.Choice;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class CostumeResponse {
    private String question;
    private String url;
    private List<Choice> choices;
}
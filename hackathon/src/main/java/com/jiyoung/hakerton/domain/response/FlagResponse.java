package com.jiyoung.hakerton.domain.response;

import com.jiyoung.hakerton.domain.Choice;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.security.auth.callback.ChoiceCallback;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class FlagResponse {
    private String question;
    private String url;
    private List<Choice> choices;
}
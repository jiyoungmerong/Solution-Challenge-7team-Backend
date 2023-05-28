package com.jiyoung.hakerton.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Flag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String url; // 국기 url

    private String question; // 국기_질문

    private String info; // 국기_설명

    private String hint; // 국기_힌트

    private String answer; // 국기_정답

    @OneToOne
    @JoinColumn(name = "id")
    private Choice choice;

}
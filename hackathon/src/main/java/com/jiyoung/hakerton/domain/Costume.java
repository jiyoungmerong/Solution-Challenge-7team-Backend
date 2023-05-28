package com.jiyoung.hakerton.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Costume {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String url; // 의상_url

    private String question; // 의상_질문

    private String info; // 의상_설명

    private String hint; // 의상_힌트

    private String answer; // 의상_정답

    @OneToOne
    @JoinColumn(name = "id")
    private Choice choice;

}
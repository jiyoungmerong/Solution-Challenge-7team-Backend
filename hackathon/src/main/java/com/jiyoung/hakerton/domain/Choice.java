package com.jiyoung.hakerton.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Choice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String one; // 객관식 1

    private String two; // 객관식 2

    private String three; // 객관식 3

    private String four; // 객관식 4

    @OneToOne
    private Costume costume;

    @OneToOne
    private Flag flag;

}


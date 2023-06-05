package com.barcode.solution_challenge_7_back.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name="User")
public class User {
    @Id
    @Column(name="user_id", unique = true)
    private String id; // 아이디

    @Column(name = "user_pw", unique = true)
    private String password; // 비밀번호

    @Column(name = "user_nickname", unique = true, length = 20)
    private String nickname; // 닉네임

    private String date; // 분리수거 버리는 날 지정

    @Builder
    public User(String id, String password, String nickname, String date){
        this.id = id;
        this.password = password;
        this.nickname = nickname;
        this.date = date;
    }

}
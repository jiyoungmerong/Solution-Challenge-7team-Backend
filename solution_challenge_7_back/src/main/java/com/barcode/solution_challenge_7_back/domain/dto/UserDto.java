package com.barcode.solution_challenge_7_back.domain.dto;

import com.barcode.solution_challenge_7_back.domain.User;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@NoArgsConstructor
public class UserDto {

    @NotNull(message = "아이디는 필수 입력 값입니다.")
    private String id; // 유저 아이디

    @NotBlank(message = "비밀번호는 필수 입력 값입니다.")
    @Pattern(regexp = "(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{8,16}", message = "비밀번호는 8~16자 영문 대 소문자, 숫자, 특수문자를 사용하세요.")
    private String password; // 유저 비밀번호

    @NotBlank
    @Pattern(regexp = "^[가-힣a-zA-Z]{2,10}$", message = "닉네임 형식에 맞지 않습니다.")
    private String nickname; // 유저 닉네임

    @NotBlank(message = "쓰레기 버리는 날은 필수 입력 값입니다.")
    private String date; // 쓰레기 버리는 날

    @Builder
    public UserDto(String id, String password, String nickname, String date){
        this.id = id;
        this.password = password;
        this.nickname = nickname;
        this.date = date;
    }
}
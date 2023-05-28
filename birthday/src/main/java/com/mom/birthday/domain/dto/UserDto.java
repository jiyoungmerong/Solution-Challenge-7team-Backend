package com.mom.birthday.domain.dto;

import com.mom.birthday.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private String userId; // 아이디

    private String password; // 비밀번호

    private String name; // 이름

    private String nickname; // 닉네임


}

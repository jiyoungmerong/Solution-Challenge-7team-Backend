package com.mom.birthday.controller;

import com.mom.birthday.domain.User;
import com.mom.birthday.domain.dto.UserDto;
import com.mom.birthday.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequiredArgsConstructor
public class SignupController {

    private final UserService userService;


    @PostMapping("/signup")
    public String handleSignupRequest(@RequestBody UserDto userDto) {
        try {
            // 사용자 정보 검증 및 데이터베이스에 저장
            User user = new User();
            user.setUserId(userDto.getUserId());
            user.setName(userDto.getName());
            user.setNickname(userDto.getNickname());
            user.setPassword(userDto.getPassword());

            userService.join(user);

            // 회원가입 완료 후 메인 페이지로 리다이렉션
            return "redirect:/main";
        } catch (Exception e) {
            // 회원가입 실패 시 에러 페이지로 리다이렉션
            return "redirect:/error";
        }
    }

}

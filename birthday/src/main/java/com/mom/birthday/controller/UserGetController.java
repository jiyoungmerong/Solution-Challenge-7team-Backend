package com.mom.birthday.controller;

import com.mom.birthday.domain.dto.UserDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class UserGetController {
    @GetMapping("/login.html")
    public String login() {
        return "login";
    }

    @GetMapping("/join.html")
    public String join() {
        return "join";
    }

    @GetMapping("/signup")
    public String signUpForm(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "join";
    }
    @GetMapping("/main")
    public String main(){
        return "main";
    }
    @GetMapping("/message_list")
    public String message(){
        return "message_list";
    }

}

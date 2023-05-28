package com.mom.birthday.controller;

import com.mom.birthday.domain.User;
import com.mom.birthday.domain.dto.LoginRequest;
import com.mom.birthday.domain.dto.TokenDTO;
import com.mom.birthday.domain.dto.UserDto;
import com.mom.birthday.jwt.TokenProvider;
import com.mom.birthday.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    private final TokenProvider tokenProvider;

//    @PostMapping("/signup")
//    public ResponseEntity<String> signUp(@Valid  @ModelAttribute UserDto userDto, BindingResult bindingResult) {
//        if(bindingResult.hasErrors()) {
//            return ResponseEntity.badRequest().body("잘못된 입력값이 존재합니다.");
//        }
//        userService.join(userDto);
//        return ResponseEntity.ok("success Join");
//    }


//    @PostMapping("/login")
//    public TokenDTO login(@RequestBody LoginRequest request){
//        String userId = request.getUserId();
//        String password = request.getPassword();
//        TokenDTO tokenDTO = userService.login(userId, password);
//
//        return tokenDTO;
//    }

//    @PostMapping("/login")
//    public TokenDTO login(@RequestBody LoginRequest request) {
//        TokenDTO tokenDTO = userService.login(request);
//
//        return tokenDTO.builder()
//                .grantType(tokenDTO.getGrantType())
//                .accessToken(tokenDTO.getAccessToken())
//                .refreshToken(tokenDTO.getRefreshToken())
//                .build();
//    }

    @PostMapping("/login")
    public ResponseEntity<TokenDTO> authorize(@Valid @RequestBody LoginRequest loginRequest) {
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(loginRequest.getUserId(), loginRequest.getPassword());

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);

//        try {
//            authentication = authenticationManager.authenticate(authenticationToken);
//        } catch (AuthenticationException e) {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
//        } finally {
//            SecurityContextHolder.getContext().setAuthentication(authentication);
//        }

        TokenDTO tokenDTO = tokenProvider.createToken(authentication);
        return ResponseEntity.ok().body(tokenDTO);
    }

}
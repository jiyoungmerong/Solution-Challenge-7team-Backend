package com.barcode.solution_challenge_7_back.controller;

import com.barcode.solution_challenge_7_back.domain.User;
import com.barcode.solution_challenge_7_back.domain.dto.ApiResponse;
import com.barcode.solution_challenge_7_back.domain.request.LoginRequest;
import com.barcode.solution_challenge_7_back.domain.request.SignupRequest;
import com.barcode.solution_challenge_7_back.domain.response.SignupResponse;
import com.barcode.solution_challenge_7_back.exception.status.SuccessStatus;
import com.barcode.solution_challenge_7_back.repository.UserRepository;
import com.barcode.solution_challenge_7_back.service.UserService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final UserRepository userRepository;

    @ApiOperation(value="회원가입", notes = "올바른 회원가입 하면 200")
    @PostMapping("/users/new-user") // 회원가입
    public ApiResponse<SignupResponse> join(@RequestBody SignupRequest request) {
        return ApiResponse.success(SuccessStatus.SIGNUP_SUCCESS, userService.create(request));
    }

    @ApiOperation(value="로그인", notes = "성공하면 로그인 됨요")
    @PostMapping("/login") // 로그인
    public ResponseEntity<Boolean> login(@RequestBody LoginRequest request) {
        boolean isAuthenticated = userService.checkLogin(request.getId(), request.getPassword());
        return isAuthenticated ? ResponseEntity.ok(true) : ResponseEntity.badRequest().body(false);
    }

    @ApiOperation(value="아이디 중복 확인", notes = "중복이면 true, 중복이 아니면 false")
    @GetMapping("/checkDuplicateId/{id}") // 아이디 중복 확인
    public boolean checkDuplicateId(@PathVariable String id) {
        return userService.checkDuplicateId(id);
    }

    @ApiOperation(value="닉네임 중복 확인", notes = "중복이면 true, 중복이 아니면 false")
    @GetMapping("/checkDuplicateNickname/{nickname}")
    public boolean checkDuplicateNickname(@PathVariable String nickname) {
        return userService.checkDuplicateNickname(nickname);
    }

    @ApiOperation(value="유저의 date 가져오기")
    @GetMapping("/user/{userId}/day")
    public ResponseEntity<String> getUserCustomDay(@PathVariable String userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            String date = user.getDate();
            if (date != null && !date.isEmpty()) {
                return ResponseEntity.ok(date);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Custom day not found for user " + userId);
            }
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("User not found with id " + userId);
        }

    }
}
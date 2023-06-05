package com.barcode.solution_challenge_7_back.controller;

import com.barcode.solution_challenge_7_back.domain.User;
import com.barcode.solution_challenge_7_back.domain.dto.ApiResponse;
import com.barcode.solution_challenge_7_back.domain.request.LoginRequest;
import com.barcode.solution_challenge_7_back.domain.request.SignupRequest;
import com.barcode.solution_challenge_7_back.domain.response.SignupResponse;
import com.barcode.solution_challenge_7_back.exception.status.SuccessStatus;
import com.barcode.solution_challenge_7_back.repository.UserRepository;
import com.barcode.solution_challenge_7_back.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
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


    @ApiOperation(value = "회원가입", notes = "새로운 사용자를 회원으로 등록합니다.")
    @ApiResponses(value = {
            @io.swagger.annotations.ApiResponse(code = 200, message = "회원가입 성공"),
            @io.swagger.annotations.ApiResponse(code = 400, message = "잘못된 요청 형식"),
            @io.swagger.annotations.ApiResponse(code = 500, message = "서버 오류")
    })
    @PostMapping("/users/new-user") // 회원가입
    public ApiResponse<SignupResponse> join(@RequestBody SignupRequest request) {
        return ApiResponse.success(SuccessStatus.SIGNUP_SUCCESS, userService.create(request));
    }

    @ApiOperation(value = "로그인", notes = "아이디, 비밀번호로 로그인")
    @ApiResponses(value = {
            @io.swagger.annotations.ApiResponse(code = 200, message = "로그인 성공"),
            @io.swagger.annotations.ApiResponse(code = 400, message = "잘못된 요청 형식"),
            @io.swagger.annotations.ApiResponse(code = 500, message = "서버 오류")
    })
    @PostMapping("/login") // 로그인
    public ResponseEntity<Boolean> login(@RequestBody LoginRequest request) {
        boolean isAuthenticated = userService.checkLogin(request.getId(), request.getPassword());
        return isAuthenticated ? ResponseEntity.ok(true) : ResponseEntity.badRequest().body(false);
    }

    @ApiOperation(value = "아이디 중복 확인", notes = "해당 id가 이미 존재한다면 true, 존재하지 않다면 false를 반환합니다.")
    @ApiImplicitParam(name = "id", value = "사용자가 생성한 id")
    @GetMapping("/checkDuplicateId/{id}") // 아이디 중복 확인
    public boolean checkDuplicateId(@PathVariable String id) {
        return userService.checkDuplicateId(id);
    }

    @ApiOperation(value = "닉네임 중복 확인", notes = "해당 닉네임이 이미 존재한다면 true, 존재하지 않다면 false를 반환합니다.")
    @ApiImplicitParam(name = "nickname", value = "사용자가 생성한 닉네임")
    @GetMapping("/checkDuplicateNickname/{nickname}")
    public boolean checkDuplicateNickname(@PathVariable String nickname) {
        return userService.checkDuplicateNickname(nickname);
    }

    @ApiOperation(value = "유저 날짜 가져오기", notes = "회원가입할 때 저장한 날짜를 가져옵니다.")
    @ApiImplicitParam(name = "userId", value = "사용자의 userId")
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
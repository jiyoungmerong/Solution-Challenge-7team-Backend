package com.barcode.solution_challenge_7_back.controller;

import com.barcode.solution_challenge_7_back.domain.User;
import com.barcode.solution_challenge_7_back.domain.dto.ApiResponseDto;
import com.barcode.solution_challenge_7_back.domain.dto.UserDto;
import com.barcode.solution_challenge_7_back.domain.request.LoginRequest;
import com.barcode.solution_challenge_7_back.domain.response.DateResponse;
import com.barcode.solution_challenge_7_back.domain.response.LoginResponse;
import com.barcode.solution_challenge_7_back.domain.response.SignupResponse;
import com.barcode.solution_challenge_7_back.repository.UserRepository;
import com.barcode.solution_challenge_7_back.service.UserService;
import com.barcode.solution_challenge_7_back.status.ErrorStatus;
import com.barcode.solution_challenge_7_back.status.SuccessStatus;
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
    public ApiResponseDto<SignupResponse> join(@RequestBody UserDto userDto) {
        try {
//            if(userService.checkDuplicateId(userDto.getId())){ // 아이디 중복 시
//                return ApiResponseDto.error(ErrorStatus.CONFLICT_ID_EXCEPTION);
//
//            } else if (userService.checkDuplicateNickname(userDto.getNickname())) { // 닉네임 중복시
//                return ApiResponseDto.error(ErrorStatus.CONFLICT_NICKNAME_EXCEPTION);
//            }
            return ApiResponseDto.success(SuccessStatus.SIGNUP_SUCCESS, userService.save(userDto)); // 회원가입 성공
        } catch (Exception e) { // 그 밖의 예외 발생시
            return ApiResponseDto.error(ErrorStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ApiOperation(value = "로그인", notes = "아이디, 비밀번호로 로그인")
    @ApiResponses(value = {
            @io.swagger.annotations.ApiResponse(code = 200, message = "로그인 성공"),
            @io.swagger.annotations.ApiResponse(code = 400, message = "잘못된 요청 형식"),
            @io.swagger.annotations.ApiResponse(code = 500, message = "서버 오류")
    })
    @PostMapping("/login") // 로그인
    public ApiResponseDto<LoginResponse> login(@RequestBody LoginRequest request) {
        boolean isAuthenticated = userService.checkLogin(request.getId(), request.getPassword());
        return isAuthenticated ? ApiResponseDto.success(SuccessStatus.LOGIN_SUCCESS, LoginResponse.of(request.getId())) : ApiResponseDto.error(ErrorStatus.USER_CERTIFICATION_FAILED);
    }

    @ApiOperation(value = "아이디 중복 확인", notes = "해당 id가 이미 존재한다면 true, 존재하지 않다면 false를 반환합니다.")
    @ApiImplicitParam(name = "id", value = "사용자가 생성한 id")
    @GetMapping("/checkDuplicateId/{id}") // 아이디 중복 확인
    public ApiResponseDto<String> checkDuplicateId(@PathVariable String id) {
        boolean isDuplicateId = userService.checkDuplicateId(id);
        return isDuplicateId ? ApiResponseDto.success(SuccessStatus.CREATE_ID_SUCCESS, id) : ApiResponseDto.error(ErrorStatus.CONFLICT_ID_EXCEPTION);
    }

    @ApiOperation(value = "닉네임 중복 확인", notes = "해당 닉네임이 이미 존재한다면 true, 존재하지 않다면 false를 반환합니다.")
    @ApiImplicitParam(name = "nickname", value = "사용자가 생성한 닉네임")
    @GetMapping("/checkDuplicateNickname/{nickname}")
    public ApiResponseDto<String> checkDuplicateNickname(@PathVariable String nickname) {
        boolean isDuplicateNickname = userService.checkDuplicateNickname(nickname);
        return isDuplicateNickname ? ApiResponseDto.success(SuccessStatus.CREATE_NICKNAME_SUCCESS, nickname) : ApiResponseDto.error(ErrorStatus.CONFLICT_NICKNAME_EXCEPTION);
    }

//    @ApiOperation(value = "유저 날짜 가져오기", notes = "회원가입할 때 저장한 날짜를 가져옵니다.")
//    @ApiImplicitParam(name = "userId", value = "사용자의 userId")
//    @GetMapping("/user/{userId}/day")
//    public ResponseEntity<String> getUserCustomDay(@PathVariable String userId) {
//        Optional<User> optionalUser = userRepository.findById(userId);
//        if (optionalUser.isPresent()) {
//            User user = optionalUser.get();
//            String date = user.getDate();
//            if (date != null && !date.isEmpty()) {
//                return ResponseEntity.ok(date);
//            } else {
//                return ResponseEntity.status(HttpStatus.NOT_FOUND)
//                        .body("Custom day not found for user " + userId);
//            }
//        } else {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND)
//                    .body("User not found with id " + userId);
//        }
//    }

    @ApiOperation(value = "유저 날짜 가져오기", notes = "회원가입할 때 저장한 날짜를 가져옵니다.")
    @ApiImplicitParam(name = "userId", value = "사용자의 userId")
    @GetMapping("/user/{userId}/day")
    public ApiResponseDto<DateResponse> getUserCustomDay(@PathVariable String userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            return ApiResponseDto.success(SuccessStatus.BRING_DATE_SUCCESS, DateResponse.of(user.getDate()));
        } else {
            return ApiResponseDto.error(ErrorStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
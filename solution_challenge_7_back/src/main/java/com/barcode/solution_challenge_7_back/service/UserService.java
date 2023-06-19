package com.barcode.solution_challenge_7_back.service;

import com.barcode.solution_challenge_7_back.domain.User;
import com.barcode.solution_challenge_7_back.domain.dto.UserDto;
import com.barcode.solution_challenge_7_back.domain.request.SignupRequest;
import com.barcode.solution_challenge_7_back.domain.response.SignupResponse;
import com.barcode.solution_challenge_7_back.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void save(UserDto userDto){
        User user = User.builder()
                .id(userDto.getId())
                .password(passwordEncoder.encode(userDto.getPassword()))
                .nickname(userDto.getNickname())
                .date(userDto.getDate())
                .build();

        userRepository.save(user);
    }


    public String login(String id, String password){ // 로그인
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent() && passwordEncoder.matches(password, user.get().getPassword())){
            return "true";
        }
        else{
            return "false";
        }
    }

    public boolean checkLogin(String id, String password) {
        Optional<User> user = userRepository.findById(id);
        if(!user.isPresent()){
            return false;
        }
        return passwordEncoder.matches(password, user.get().getPassword());
    }


    public boolean checkDuplicateNickname(String username) {
        return userRepository.findByNickname(username).isPresent();
    }


    public boolean checkDuplicateId(String id){
        return userRepository.findById(id).isPresent();
    }


}
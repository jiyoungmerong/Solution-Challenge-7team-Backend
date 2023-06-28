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
    public SignupResponse save(SignupRequest request){
        User user = User.builder()
                .id(request.getId())
                .password(passwordEncoder.encode(request.getPassword()))
                .nickname(request.getNickname())
                .date(request.getDate())
                .build();

        userRepository.save(user);

        return SignupResponse.from(user.getId(), user.getNickname(), user.getDate());
    }

    public boolean checkLogin(String id, String password) {
        Optional<User> user = userRepository.findById(id);
        if(!user.isPresent()){
            return false;
        }
        return passwordEncoder.matches(password, user.get().getPassword());
    }

    public boolean checkDuplicateNickname(String username) {
        return !userRepository.findByNickname(username).isPresent();
    }


    public boolean checkDuplicateId(String id){
        return !userRepository.findById(id).isPresent();
    }
}
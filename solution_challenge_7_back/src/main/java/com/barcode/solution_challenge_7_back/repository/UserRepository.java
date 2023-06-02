package com.barcode.solution_challenge_7_back.repository;

import com.barcode.solution_challenge_7_back.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    Optional<User> findById(String id);

    Optional<User> findByNickname(String nickname);
}
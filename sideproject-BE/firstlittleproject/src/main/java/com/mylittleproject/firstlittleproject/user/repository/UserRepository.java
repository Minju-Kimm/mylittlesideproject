package com.mylittleproject.firstlittleproject.user.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mylittleproject.firstlittleproject.user.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByEmail(String email); //email로 사용자 식별하기
}

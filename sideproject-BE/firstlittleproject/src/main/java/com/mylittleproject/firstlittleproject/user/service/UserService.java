package com.mylittleproject.firstlittleproject.user.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.mylittleproject.firstlittleproject.user.dto.AddUserRequest;
import com.mylittleproject.firstlittleproject.user.entity.User;
import com.mylittleproject.firstlittleproject.user.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {

	private final UserRepository userRepository;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;

	public Long save(AddUserRequest addUserRequestDto) {
		return userRepository.save(User.builder()
			.username(addUserRequestDto.username())
			.email(addUserRequestDto.email())
			.password(bCryptPasswordEncoder.encode(addUserRequestDto.password())) //password 인코딩(암호화하기)
			.build()).getId();
	}

	public User findById(Long userId) {
		return userRepository.findById(userId)
			.orElseThrow(() -> new IllegalArgumentException("User not found"));
	}
}

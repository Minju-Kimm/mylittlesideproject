package com.mylittleproject.firstlittleproject.user.service;

import org.springframework.stereotype.Service;

import com.mylittleproject.firstlittleproject.user.entity.RefreshToken;
import com.mylittleproject.firstlittleproject.user.repository.RefreshTokenRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class RefreshTokenService {

	private final RefreshTokenRepository refreshTokenRepository;

	public RefreshToken findByRefreshToken(String refreshToken) {
		return refreshTokenRepository.findByRefreshToken(refreshToken)
			.orElseThrow(() -> new IllegalArgumentException("Unexpected Token"));
	}
}

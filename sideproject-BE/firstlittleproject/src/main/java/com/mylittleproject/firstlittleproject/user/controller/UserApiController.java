package com.mylittleproject.firstlittleproject.user.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mylittleproject.firstlittleproject.user.dto.AddUserRequest;
import com.mylittleproject.firstlittleproject.user.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@RequestMapping("/api/user")
@RequiredArgsConstructor
@RestController
public class UserApiController {

	private final UserService userService;

	@PostMapping("")
	public ResponseEntity<String> signup(@RequestBody AddUserRequest request) {
		userService.save(request);
		return ResponseEntity.ok().body("회원가입에 성공하였습니다. 축하축하");
	}

	@GetMapping("/logout")
	public ResponseEntity<String> logout(HttpServletRequest request, HttpServletResponse response) {
		new SecurityContextLogoutHandler().logout(request, response, SecurityContextHolder.getContext().getAuthentication());
		return ResponseEntity.ok().body("로그아웃에 성공하였습니다. 축하할 일인가요? 일단 축하드립니다. ㅎㅎ");
	}
}

package com.mylittleproject.firstlittleproject.user.dto;


public record AddUserRequest(
	String username,
	String email,
	String password
) {

}

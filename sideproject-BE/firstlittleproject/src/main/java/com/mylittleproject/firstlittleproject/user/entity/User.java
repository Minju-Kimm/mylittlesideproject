package com.mylittleproject.firstlittleproject.user.entity;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "users")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class User implements UserDetails { //UserDetails 상속받아 인증 객체로 사용함

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id", updatable = false, nullable = false)
	private Long id;

	@Column(name = "user_name", nullable = false)
	private String username; //사용자 성명

	@Column(name = "email", nullable = false, unique = true)
	private String email; //사용자 이메일

	@Column(name = "password", nullable = false)
	private String password; //사용자 비밀번호

	@Builder //빌더 패턴을 사용할 것!
	public User(String username, String email, String password) {
		this.username = username;
		this.email = email;
		this.password = password;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		//권한 반환하는 로직
		return List.of(new SimpleGrantedAuthority("user"));
	}

	@Override
	public boolean isCredentialsNonExpired() {
		//패스워드 만료되었나 확인하는 로직
		return true; //만료되지 않았음 리턴
	}

	@Override
	public boolean isEnabled() {
		//계정 사용 가능 여부 반환
		return true; //사용 가능함
	}

	@Override
	public boolean isAccountNonLocked() {
		//계정 잠금 여부 반환
		return true; //true -> 잠금되지 않았음
	}


	@Override
	public boolean isAccountNonExpired() {
		//계정 만료 여부 반환
		return true; //true -> 만료되지 않았음
	}
}

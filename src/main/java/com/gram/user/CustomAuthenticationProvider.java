package com.gram.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;


public class CustomAuthenticationProvider implements AuthenticationProvider {
	
	@Autowired
	private UserService userService;
	@Autowired
	private PasswordEncoder passwordEncoder;
	


	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = (String) authentication.getPrincipal();
		String password = (String) authentication.getCredentials();
		
		System.out.println("111");
		
		UserSecurityVO user = (UserSecurityVO) userService.loadUserByUsername(username);
		
		System.out.println("=== 작업중");
		System.out.println(password);
		System.out.println(user.getPassword());
		
//		password 일치하지 않으면!
        if(!passwordEncoder.matches(password, user.getPassword())){
            throw new BadCredentialsException("BadCredentialsException");
        }
		
		return new UsernamePasswordAuthenticationToken(username, password, user.getAuthorities());
	}

	// 토큰 타입과 일치할 때 인증
	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		// return false 하면 이 클래스 안탐
		return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
	}

}

package com.gram.user;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserService implements UserDetailsService {
	
	private UserMapper userMapper;
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	public UserService(UserMapper userMapper, PasswordEncoder passwordEncoder) {
		this.userMapper = userMapper;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
		log.info("userId = " + userId);
		if(userId == null && userId.equals("")) {
			userId = "admin";
		}
		//DB로부터 회원 정보를 가져온다.
		ArrayList<UserVO> userVO = userMapper.loginUser(userId);
		System.out.println(userVO.toString());
		if(userVO.size() == 0) {
			throw new UsernameNotFoundException("user" + userId + "not found!");
		}
		userVO.get(0).setUserPassword(passwordEncoder.encode(userVO.get(0).getUserPassword()));
		
		System.out.println(passwordEncoder.encode(userVO.get(0).getUserPassword()));
		
		return new UserSecurityVO(userVO);
	}
	
}

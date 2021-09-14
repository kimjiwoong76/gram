package com.gram.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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
		//DB로부터 회원 정보를 가져온다.
		ArrayList<UserVO> userVO = userMapper.loginUser(userId);
		if(userVO.size() == 0) {
			throw new UsernameNotFoundException("user" + userId + "not found!");
		}
		return new UserSecurityVO(userVO);
	}
	
	public void memberSave(UserVO userVO) {
		try {
			userVO.setUserAuth(1);
			userVO.setUserPassword(passwordEncoder.encode(userVO.getUserPassword()));
			userMapper.memberSave(userVO);
			userMapper.authSave(userVO);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public Boolean userSelect(UserVO userVO) {
		return userMapper.userSelect(userVO);
	}
	
	
}

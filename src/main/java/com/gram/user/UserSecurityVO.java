package com.gram.user;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserSecurityVO implements UserDetails {

	private static final String ROLE_PREFIX = "ROLE_";
	private ArrayList<UserVO> userVO;
	
	public UserSecurityVO(ArrayList<UserVO> userVO) {
		this.userVO = userVO;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		System.out.println("adsf");
		for(int i=0; i<userVO.size(); i++) {
			authorities.add(new SimpleGrantedAuthority(ROLE_PREFIX+userVO.get(i).getAuth()));
		}
		return authorities;
	}

	@Override
	public String getPassword() {
		return userVO.get(0).getUserPassword();
	}

	@Override
	public String getUsername() {
		return userVO.get(0).getUserId();
	}

	@Override
	// 계정이 만료 되지 않았는가?
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	// 계정이 잠기지 않았는가?
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	// 패스워드가 만료되지 않았는가?
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	// 계정이 활성화 되었는가?
	public boolean isEnabled() {
		return true;
	}


}

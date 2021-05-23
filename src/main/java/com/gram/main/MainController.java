package com.gram.main;

import java.security.Principal;
import java.util.Collection;
import java.util.Iterator;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
	
	@RequestMapping(value="/member/mypage", method = RequestMethod.GET)
	public String mypage() {
		return "/member/mypage";
	}
	
	@RequestMapping("/")
	public String main(Principal principal) {
		// 시큐리티 컨텍스트 객체를 얻습니다. 
		SecurityContext context = SecurityContextHolder.getContext(); 
		// 인증 객체를 얻습니다. 
		Authentication authentication = context.getAuthentication();
		// 사용자가 가진 모든 롤 정보를 얻습니다. 
		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities(); 
		Iterator<? extends GrantedAuthority> iter = authorities.iterator(); 
		while (iter.hasNext()) { 
			GrantedAuthority auth = iter.next(); 
			System.out.println(auth.getAuthority().toString()); 
		}
//		System.out.println(principal.getName());
		return "/app/index";
	}
	
	
}

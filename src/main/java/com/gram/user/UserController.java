package com.gram.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.authentication.AuthenticationTrustResolverImpl;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/user")
public class UserController {

	
	private UserService userService;
	
	public UserController(UserService userService) {		
		this.userService = userService;
	}

	// 로그인 페이지 이동
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginForm(HttpServletRequest request) {
		String referer_url = request.getHeader("referer");
		AuthenticationTrustResolver trustResolver = new AuthenticationTrustResolverImpl();
		if (trustResolver.isAnonymous(SecurityContextHolder.getContext().getAuthentication())) {
			// 익명사용자
			System.out.println("!@##################" + referer_url);
			return "/user/login";
		}
		else { 
			System.out.println("#################" + referer_url);
			// 로그인 사용자
			return "/app/index"; 
		}
		
	}

	
	// 로그인 프로세스
	@RequestMapping(value="/loginProcess", method = RequestMethod.POST)
	public String loginProcess2(UserVO userVO) {
		log.info("여기 타나요");
		System.out.println("userVO" + userVO.getUserId());
		String userName = userVO.getUserId();
		userService.loadUserByUsername(userName);
		return "redirect:/app";
	}
	
	// 로그아웃 프로세스
	@RequestMapping(value = "/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if(authentication != null) {
			new SecurityContextLogoutHandler().logout(request, response, authentication);
		}
		return "redirect:/user/login";
	}
	
	
	
	
}

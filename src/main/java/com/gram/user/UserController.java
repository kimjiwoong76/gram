package com.gram.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.authentication.AuthenticationTrustResolverImpl;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
	@RequestMapping(value = "/login")
	public String loginForm(HttpServletRequest request) {
		return null;
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
	
	// 회원가입 페이지 이동
	@GetMapping("/signUp")
	public String signUp() {
		return "/user/signUp";
	}
	
	// 회원가입 폼
	@PostMapping("/signForm")
	public String signForm() {
		return "/user/signForm";
	}
	
	
	
	
}

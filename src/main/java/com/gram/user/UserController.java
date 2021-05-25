package com.gram.user;

import java.io.PrintWriter;

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
	
	@RequestMapping(value = "/accessDenied")
	public void userAccessDenied(HttpServletResponse response) throws Exception{
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<script>alert('접근 권한이 없습니다.'); history.go(-1)</script>");
		out.flush();
	}
	
	// 로그아웃 프로세스
	@RequestMapping(value = "/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		log.info("로그아웃 실행");
		return null;
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
	
	// 회원가입 action
	@PostMapping("/signFormAction")
	public String signFormAction(UserVO userVO) {
		userService.memberSave(userVO);
		return "result";
	}
	
	
	
	
}

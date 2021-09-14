package com.gram.user;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/user")
public class UserController {

	private final String path = "/user/";
	
	private UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	// 로그인 페이지 이동
	@RequestMapping(value = "/login")
	public String loginForm(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "/user/login";
	}

	@RequestMapping(value = "/accessDenied")
	public void userAccessDenied(HttpServletResponse response) throws Exception {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<script>alert('접근 권한이 없습니다.'); history.go(-1)</script>");
		out.flush();
	}

	// 로그아웃 프로세스
	@RequestMapping(value = "/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response, UserVO userVO) {
		log.info("로그아웃 실행");
//		userService.loadUserByUsername(userVO.userId);
		return null;
	}

	// 회원가입 페이지 이동
	@GetMapping("/signUp")
	public String signUp() {
		return "/user/signUp";
	}

	// 회원가입 폼
	@PostMapping("/signForm")
	public String signForm(Model model) {
		String url = "signForm";
		model.addAttribute("script", url);
		return path + url;
	}
	
	// 회원가입 유저아이디 검사
	@GetMapping("/userSelect")
	@ResponseBody
	public Boolean userSelect(@Valid UserVO userVO, Errors errors) {
		if(errors.hasErrors()) {
			System.err.println(errors);
		}
		System.out.println(userVO.toString());
		Boolean result = userService.userSelect(userVO);
		System.out.println(result);
		return result;
	}

	// 회원가입 action
	@PostMapping("/signFormAction")
	public String signFormAction(@Valid UserVO userVO) {
		System.out.println(userVO.toString());
		userService.memberSave(userVO);
		return "redirect:/";
	}

}

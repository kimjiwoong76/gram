package com.gram.User;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gram.domain.UserVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/user")
public class UserController {

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginView() {
		System.out.println("login View");
		return "/user/login";
	}
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String loginProcess(UserVO userVO) {
		System.out.println("LoginProcess");
		System.out.println(userVO.toString());
		return "/user/mypage";
	}
	
	
}

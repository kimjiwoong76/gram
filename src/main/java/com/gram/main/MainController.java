package com.gram.main;

import java.security.Principal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
	
	@RequestMapping(value="/user/mypage", method = RequestMethod.GET)
	public String mypage() {
		return "/user/mypage";
	}
	
	@RequestMapping("/")
	public String main(Principal principal) {
//		System.out.println(principal.getName());
		return "/app/index";
	}
	
	
}

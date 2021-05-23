package com.gram.admin;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gram.user.UserVO;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@RequestMapping(value = "/index")
	public String admIndex(UserVO userVO)  {
		System.out.println("관리자 로그인");
		return "/admin/index";
	}
}

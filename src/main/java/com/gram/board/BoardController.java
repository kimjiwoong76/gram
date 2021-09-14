package com.gram.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	private final String PATH = "/board";
	
	@RequestMapping("/list")
	public String list() {
		String url = "list";
		return PATH + url;
	}
	
	@RequestMapping("/view")
	public String view() {
		String url = "view";
		return PATH + url;
	}
	
	@RequestMapping("/write")
	public String write() {
		String url = "write";
		return PATH + url;
	}
	
	
}

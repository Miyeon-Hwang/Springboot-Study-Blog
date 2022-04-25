package com.hmy.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

	@GetMapping("/join")
	public String join() {
		return "user/joinForm";
	}
	
	@GetMapping("/login")
	public String login() {
		return "user/loginForm";
	}
}

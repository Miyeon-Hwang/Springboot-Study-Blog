package com.hmy.blog.controller.api;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.embedded.undertow.UndertowServletWebServer;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hmy.blog.dto.ResponseDto;
import com.hmy.blog.model.RoleType;
import com.hmy.blog.model.User;
import com.hmy.blog.service.UserService;

@RestController
public class UserAPIController {

	@Autowired
	private UserService userService;
	
//	@Autowired
//	private HttpSession session;
	
	@PostMapping("/api/join")
	public ResponseDto<Integer> save(@RequestBody User user) {
		System.out.println("UserAPIController : save()");
		user.setRole(RoleType.USER);
		userService.join(user);
		return new ResponseDto<Integer> (HttpStatus.OK.value(), 1); // 자바 오브젝트를 json으로 변환해서 리턴(Jackson)
	}

// 전통적인 스프링 로그인 방식, security 적용안되어있음!
//	@PostMapping("/api/login")
//	public ResponseDto<Integer> login(@RequestBody User user, HttpSession session) { // HttpSession 객체는 bean으로 가지고있음. 위에 주석처리해놓은 session 객체로 사용해도 되고 매개변수로 받아도 DI로 가져옴.
//		System.out.println("UserAPIController : login()");
//		User principal = userService.login(user); // principal(접근주체) : 많이 사용되는 용어
//		
//		if (principal != null) {
//			session.setAttribute("principal", principal);
//		}
//		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
//	}
}

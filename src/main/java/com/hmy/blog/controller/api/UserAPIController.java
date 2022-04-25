package com.hmy.blog.controller.api;

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
	
	@PostMapping("/api/user")
	public ResponseDto<Integer> save(@RequestBody User user) {
		System.out.println("UserAPIController : save()");
		user.setRole(RoleType.USER);
		userService.join(user);
		return new ResponseDto<Integer> (HttpStatus.OK.value(), 1); // 자바 오브젝트를 json으로 변환해서 리턴(Jackson)
	}
}

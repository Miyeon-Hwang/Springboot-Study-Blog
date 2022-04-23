package com.hmy.blog.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
public class HttpControllerTest {
	
//	@GetMapping("/http/get")
//	public String getTest(@RequestParam int id, @RequestParam String username) {
//		return "get request : " + id + ", " + username;
//	}
	@GetMapping("/http/get")
	public String getTest(Member m) {
		return "get request : " + m.getId() + ", " + m.getUsername();
	}
	
//	@PostMapping("/http/post")
//	public String postTest(@RequestBody String text) {
//		return "post request : " + text;
//	}
	
	@PostMapping("/http/post")
	public String postTest(Member m) {
		return "post request : " + m.getId() + ", " + m.getUsername() + ", " + m.getPassword() + ", " + m.getEmail();
	}
	
	@PutMapping("/http/put")
	public String putTest() {
		return "put request";
	}
	
	@DeleteMapping("/http/delete")
	public String deleteTest() {
		return "delete request";
	}
	
	@GetMapping("/http/lombok")
	public String lombokTest() {
		Member m = Member.builder().email("assdf@naver.com").id(10).build();
		System.out.println(m.getId());
		m.setId(5000);
		System.out.println(m.getId());
		Member m2 = new Member(200, "aa", "1234", "adf@naver.com");
		System.out.println(m2.getId());
		return "lombok test 완료";
	}
}

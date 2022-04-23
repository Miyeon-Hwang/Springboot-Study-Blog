package com.hmy.blog.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TemplateControllerTest {

	@GetMapping("/temp/jsp")
	public String tempJsp() {
		return "home";
	}
}

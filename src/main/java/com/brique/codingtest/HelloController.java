package com.brique.codingtest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

//ννλ¦Ώμ Controller
@Controller
public class HelloController {
	
	@GetMapping("/")
	public String root() {
		return "mainPage";
	}
	
	@GetMapping("/numberfour")
	public String hi(Model model) {
		model.addAttribute("title", "Test");
		return "NumberFour";
	}
}

package com.demo.emp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class SigninController {
	
	@GetMapping("/signin")
	public String signin() {
		return "login.html";
	}

}

package com.demo.emp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public")
public class HomeController {
	
	 @GetMapping("/home")
		public String home(@RequestParam String str)
		{
			return "this is home page : " +str;
		}

	 @GetMapping("/login")
		public String login()
		{
			return "this is login  page : ";
		}
	 @GetMapping("/register")
		public String register()
		{
			return "this is register page : ";
		}
}

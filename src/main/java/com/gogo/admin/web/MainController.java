package com.gogo.admin.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	// Home page
	@GetMapping("")
	public String viewIndexPage() {
		return "maincontroller/index";
	}
	
	// Login page
	@GetMapping("/login")
	public String viewLoginPage() {
		return "maincontroller/login";
	}
}

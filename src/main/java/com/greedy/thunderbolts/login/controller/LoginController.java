package com.greedy.thunderbolts.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@GetMapping("/main")
	public String loginMain() {
		return "login/loginMain";
	}
	
	@GetMapping("/regist")
	public String loginRegist() {
		return "login/loginRegist";
	}

	
}

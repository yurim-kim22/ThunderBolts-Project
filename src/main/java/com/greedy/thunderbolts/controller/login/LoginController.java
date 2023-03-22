package com.greedy.thunderbolts.controller.login;

import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	private final MessageSourceAccessor messageSourceAccessor;
	
	public LoginController (MessageSourceAccessor messageSourceAccessor) {
		this.messageSourceAccessor =  messageSourceAccessor;
	}
	
	
	@GetMapping("/main")
	public String loginMain() {
		return "login/loginMain";
	}
	
	@PostMapping("/false")
	public String loginFalse(RedirectAttributes rttr) {
		
		rttr.addFlashAttribute("message", messageSourceAccessor.getMessage("error.login"));
		
		return "redirect:/login/main";
		
	}
	
	@GetMapping("/regist")
	public String loginRegist() {
		return "login/loginRegist";
	}

	
}
